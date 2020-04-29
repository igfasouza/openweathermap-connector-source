package com.openweathermap.kafka.connect.model

import com.google.gson.annotations.SerializedName
import scala.beans.{BeanProperty, BooleanBeanProperty}
import scala.collection.JavaConversions._

class Wind {

  @SerializedName("speed")
  @BeanProperty
  var speed: java.lang.Float = _

  @SerializedName("deg")
  @BeanProperty
  var deg: java.lang.Integer = _

  def this(speed: java.lang.Float, deg: java.lang.Integer) = {
    this()
    this.speed = speed
    this.deg = deg
  }

}
