package com.openweathermap.kafka.connect

import java.util.Arrays

import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.stream.Collectors
import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.connect.connector.Task
import org.apache.kafka.connect.source.SourceConnector
import org.apache.kafka.connect.util.ConnectorUtils
import com.openweathermap.kafka.connect.WeatherAPIConfig.CITIES
import scala.collection.JavaConversions._

class WeatherAPIConnector extends SourceConnector {

  private var config: WeatherAPIConfig = _

  override def version(): String = "1.0"

  override def start(props: Map[String, String]): Unit = {
    config = new WeatherAPIConfig(props)
  }

  override def taskClass(): Class[_ <: Task] = classOf[WeatherAPITask]

  override def taskConfigs(maxTasks: Int): List[Map[String, String]] = {
    val cities: List[String] =
      Arrays.stream(config.getCities.split(",")).collect(Collectors.toList())
    val numGroups: Int = Math.min(cities.size, maxTasks)
    ConnectorUtils
      .groupPartitions(cities, numGroups)
      .stream()
      .map((taskCities) => {
        val taskProps: Map[String, String] =
          new HashMap[String, String](config.originalsStrings())
        taskProps.put(CITIES, String.join(",", taskCities))
        taskProps
      })
      .collect(Collectors.toList())
  }

  override def stop(): Unit = {}

  override def config(): ConfigDef = WeatherAPIConfig.config()

}
