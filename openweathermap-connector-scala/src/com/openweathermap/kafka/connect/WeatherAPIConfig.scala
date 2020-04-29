package com.openweathermap.kafka.connect

import java.util.Map
import org.apache.kafka.common.config.AbstractConfig
import org.apache.kafka.common.config.ConfigDef
import WeatherAPIConfig._
import scala.beans.{BeanProperty, BooleanBeanProperty}
import scala.collection.JavaConversions._

object WeatherAPIConfig {

  val OPEN_WEATHER_API_KEY: String = "open.weather.api.key"
  private val OPEN_WEATHER_API_KEY_DOC: String = "The API key used by connector to poll data"

  val CITIES: String = "cities"
  private val CITIES_DOC: String = "Cities that you want to check weather for"

  val POLL_FREQUENCY: String = "poll.frequency"
  private val POLL_FREQUENCY_DOC: String = "Duration between each request to Weather API"

  val KAFKA_TOPIC: String = "kafka.topic"
  private val KAFKA_TOPIC_DOC: String = "Kafka Topic to send data to"

  def config(): ConfigDef =
    new ConfigDef()
      .define(OPEN_WEATHER_API_KEY,
              ConfigDef.Type.STRING,
              ConfigDef.Importance.HIGH,
              OPEN_WEATHER_API_KEY_DOC)
      .define(CITIES,
              ConfigDef.Type.STRING,
              ConfigDef.Importance.HIGH,
              CITIES_DOC)
      .define(POLL_FREQUENCY,
              ConfigDef.Type.LONG,
              10000L,
              ConfigDef.Importance.MEDIUM,
              POLL_FREQUENCY_DOC)
      .define(KAFKA_TOPIC,
              ConfigDef.Type.STRING,
              ConfigDef.Importance.HIGH,
              KAFKA_TOPIC_DOC)

}

class WeatherAPIConfig(originals: Map[String, _])
    extends AbstractConfig(config(), originals) {

  @BeanProperty
  val openWeatherApiKey: String = this.getString(OPEN_WEATHER_API_KEY)

  @BeanProperty
  val cities: String = this.getString(CITIES)

  @BeanProperty
  val pollFrequency: java.lang.Long = this.getLong(POLL_FREQUENCY)

  @BeanProperty
  val kafkaTopic: String = this.getString(KAFKA_TOPIC)

}
