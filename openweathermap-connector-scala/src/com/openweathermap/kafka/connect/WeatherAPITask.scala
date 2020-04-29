package com.openweathermap.kafka.connect

import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.Collectors
import java.util.stream.Collectors.toList
import org.apache.kafka.connect.data.Struct
import org.apache.kafka.connect.source.SourceRecord
import org.apache.kafka.connect.source.SourceTask
import com.openweathermap.kafka.connect.model.Weather
import com.openweathermap.kafka.connect.schema.WeatherAPISchemaFields._
import com.openweathermap.kafka.connect.schema.WeatherAPISchemas._
import scala.collection.JavaConversions._

class WeatherAPITask extends SourceTask {

  private var config: WeatherAPIConfig = _

  private var client: WeatherAPIClient = _

  private var isRunning: AtomicBoolean = new AtomicBoolean(false)

  override def version(): String = "1.0"

  override def start(props: Map[String, String]): Unit = {
    config = new WeatherAPIConfig(props)
    client = new WeatherAPIClient(config)
    isRunning.set(true)
  }

  override def poll(): List[SourceRecord] = {
    if (!isRunning.get) {
      Collections.emptyList()
    }
    Thread.sleep(config.getPollFrequency)
    client.getCurrentWeather
      .stream()
      .map(
        (weather) =>
          new SourceRecord(sourcePartition(weather),
                           sourceOffset(),
                           config.getKafkaTopic,
                           KEY_SCHEMA,
                           buildKey(weather.getId),
                           VALUE_SCHEMA,
                           buildValue(weather)))
      .collect(Collectors.toList())
  }

  override def stop(): Unit = {
    isRunning.set(false)
  }

  private def sourceOffset(): Map[String, _] = new HashMap()

  private def buildKey(id: java.lang.Long): Struct =
    new Struct(KEY_SCHEMA).put(ID, id)

  private def buildValue(weather: Weather): Struct =
    new Struct(VALUE_SCHEMA)
      .put(NAME, weather.getName)
      .put(
        MAIN,
        new Struct(MAIN_SCHEMA)
          .put(TEMP, weather.getMain.getTemp)
          .put(PRESSURE, weather.getMain.getPressure)
          .put(HUMIDITY, weather.getMain.getHumidity)
          .put(TEMP_MIN, weather.getMain.getTempMin)
          .put(TEMP_MAX, weather.getMain.getTempMax)
      )
      .put(WIND,
           new Struct(WIND_SCHEMA)
             .put(SPEED, weather.getWind.getSpeed)
             .put(DEG, weather.getWind.getDeg))
      .put(
        WEATHER,
        weather.getWeather
          .stream()
          .map(
            (weatherDetails) =>
              new Struct(WEATHER_SCHEMA)
                .put(ID, weatherDetails.getId)
                .put(MAIN, weatherDetails.getMain)
                .put(DESCRIPTION, weatherDetails.getDescription)
                .put(ICON, weatherDetails.getIcon))
          .collect(toList())
      )

  private def sourcePartition(weather: Weather): Map[String, _] = {
    val sourcePartition: Map[String, String] = new HashMap[String, String]()
    sourcePartition.put("location", weather.getName)
    sourcePartition
  }

}
