package com.openweathermap.kafka.connect.model

import com.google.gson.annotations.SerializedName
import scala.beans.{BeanProperty, BooleanBeanProperty}
import scala.collection.JavaConversions._

class Main {

  @SerializedName("temp")
  @BeanProperty
  var temp: java.lang.Float = _

  @SerializedName("pressure")
  @BeanProperty
  var pressure: java.lang.Integer = _

  @SerializedName("humidity")
  @BeanProperty
  var humidity: java.lang.Integer = _

  @SerializedName("temp_min")
  @BeanProperty
  var tempMin: java.lang.Float = _

  @SerializedName("temp_max")
  @BeanProperty
  var tempMax: java.lang.Float = _

  def this(temp: java.lang.Float,
           pressure: java.lang.Integer,
           humidity: java.lang.Integer,
           tempMin: java.lang.Float,
           temp_max: java.lang.Float) = {
    this()
    this.temp = temp
    this.pressure = pressure
    this.humidity = humidity
    this.tempMin = tempMin
    this.tempMax = temp_max
  }

}
