package com.openweathermap.kafka.connect.schema

import org.apache.kafka.connect.data.Schema
import org.apache.kafka.connect.data.SchemaBuilder
import com.openweathermap.kafka.connect.schema.WeatherAPISchemaFields._
import scala.collection.JavaConversions._

object WeatherAPISchemas {

  var WEATHER_SCHEMA: Schema = SchemaBuilder
    .struct()
    .name("Weather")
    .version(1)
    .field(ID, Schema.INT64_SCHEMA)
    .field(MAIN, Schema.STRING_SCHEMA)
    .field(DESCRIPTION, Schema.STRING_SCHEMA)
    .field(ICON, Schema.STRING_SCHEMA)
    .build()

  var WEATHER_ARRAY_SCHEMA: Schema =
    SchemaBuilder.array(WEATHER_SCHEMA).build()

  var MAIN_SCHEMA: Schema = SchemaBuilder
    .struct()
    .name("Main")
    .version(1)
    .field(TEMP, Schema.FLOAT32_SCHEMA)
    .field(PRESSURE, Schema.INT32_SCHEMA)
    .field(HUMIDITY, Schema.INT32_SCHEMA)
    .field(TEMP_MIN, Schema.FLOAT32_SCHEMA)
    .field(TEMP_MAX, Schema.FLOAT32_SCHEMA)
    .build()

  var WIND_SCHEMA: Schema = SchemaBuilder
    .struct()
    .name("Wind")
    .version(1)
    .field(SPEED, Schema.OPTIONAL_FLOAT32_SCHEMA)
    .field(DEG, Schema.OPTIONAL_INT32_SCHEMA)
    .optional()
    .build()

  var KEY_SCHEMA: Schema = SchemaBuilder
    .struct()
    .name("Key Schema")
    .version(1)
    .field(ID, Schema.INT64_SCHEMA)
    .build()

  var VALUE_SCHEMA: Schema = SchemaBuilder
    .struct()
    .name("Value Schema")
    .version(1)
    .field(NAME, Schema.STRING_SCHEMA)
    .field(WEATHER, WEATHER_ARRAY_SCHEMA)
    .field(MAIN, MAIN_SCHEMA)
    .field(WIND, WIND_SCHEMA)
    .build()

}
