package com.openweathermap.kafka.connect.schema

import scala.collection.JavaConversions._

object WeatherAPISchemaFields {

  val ID: String = "id"
  val MAIN: String = "main"
  val DESCRIPTION: String = "description"
  val ICON: String = "icon"
  val TEMP: String = "temp"
  val PRESSURE: String = "pressure"
  val HUMIDITY: String = "humidity"
  val TEMP_MIN: String = "temp_min"
  val TEMP_MAX: String = "temp_max"
  val SPEED: String = "speed"
  val DEG: String = "deg"
  val NAME: String = "name"
  val WEATHER: String = "weather"
  val WIND: String = "wind"

}
