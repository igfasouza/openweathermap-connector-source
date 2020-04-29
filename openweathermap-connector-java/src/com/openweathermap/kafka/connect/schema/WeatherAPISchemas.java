package com.openweathermap.kafka.connect.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;

import static com.openweathermap.kafka.connect.schema.WeatherAPISchemaFields.*;

public class WeatherAPISchemas {

    public static Schema WEATHER_SCHEMA = SchemaBuilder.struct()
            .name("Weather")
            .version(1)
            .field(ID, Schema.INT64_SCHEMA)
            .field(MAIN, Schema.STRING_SCHEMA)
            .field(DESCRIPTION, Schema.STRING_SCHEMA)
            .field(ICON, Schema.STRING_SCHEMA)
            .build();

    public static Schema WEATHER_ARRAY_SCHEMA = SchemaBuilder.array(WEATHER_SCHEMA)
            .build();

    public static Schema MAIN_SCHEMA = SchemaBuilder.struct()
            .name("Main")
            .version(1)
            .field(TEMP, Schema.FLOAT32_SCHEMA)
            .field(PRESSURE, Schema.INT32_SCHEMA)
            .field(HUMIDITY, Schema.INT32_SCHEMA)
            .field(TEMP_MIN, Schema.FLOAT32_SCHEMA)
            .field(TEMP_MAX, Schema.FLOAT32_SCHEMA)
            .build();

    public static Schema WIND_SCHEMA = SchemaBuilder.struct()
            .name("Wind")
            .version(1)
            .field(SPEED, Schema.OPTIONAL_FLOAT32_SCHEMA)
            .field(DEG, Schema.OPTIONAL_INT32_SCHEMA)
            .optional()
            .build();

    public static Schema KEY_SCHEMA = SchemaBuilder.struct()
            .name("Key Schema")
            .version(1)
            .field(ID, Schema.INT64_SCHEMA)
            .build();

    public static Schema VALUE_SCHEMA = SchemaBuilder.struct()
            .name("Value Schema")
            .version(1)
            .field(NAME, Schema.STRING_SCHEMA)
            .field(WEATHER, WEATHER_ARRAY_SCHEMA)
            .field(MAIN, MAIN_SCHEMA)
            .field(WIND, WIND_SCHEMA)
            .build();

}
