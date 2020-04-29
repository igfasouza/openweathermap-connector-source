package com.openweathermap.kafka.connect.model

import com.google.gson.annotations.SerializedName
import scala.beans.{BeanProperty, BooleanBeanProperty}
import scala.collection.JavaConversions._

class WeatherDetails {

  @SerializedName("id")
  @BeanProperty
  var id: java.lang.Long = _

  @SerializedName("main")
  @BeanProperty
  var main: String = _

  @SerializedName("description")
  @BeanProperty
  var description: String = _

  @SerializedName("icon")
  @BeanProperty
  var icon: String = _

  def this(id: java.lang.Long,
           main: String,
           description: String,
           icon: String) = {
    this()
    this.id = id
    this.main = main
    this.description = description
    this.icon = icon
  }

  override def toString(): String =
    "WeatherDetails{" + "id=" + id + ", main='" + main + '\'' +
      ", description='" +
      description +
      '\'' +
      ", icon='" +
      icon +
      '\'' +
      '}'

}
