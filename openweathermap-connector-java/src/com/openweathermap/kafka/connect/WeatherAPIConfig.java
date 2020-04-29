package com.openweathermap.kafka.connect;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

public class WeatherAPIConfig extends AbstractConfig {

	public static final String OPEN_WEATHER_API_KEY = "open.weather.api.key";
    private static final String OPEN_WEATHER_API_KEY_DOC = "The API key used by connector to poll data";

    public static final String CITIES = "cities";
    private static final String CITIES_DOC = "Cities that you want to check weather for";

    public static final String POLL_FREQUENCY = "poll.frequency";
    private static final String POLL_FREQUENCY_DOC = "Duration between each request to Weather API";

    public static final String KAFKA_TOPIC = "kafka.topic";
    private static final String KAFKA_TOPIC_DOC = "Kafka Topic to send data to";

    private final String openWeatherApiKey;
    private final String cities;
    private final Long pollFrequency;
    private final String kafkaTopic;

    public WeatherAPIConfig(Map<String, ?> originals) {
        super(config(), originals);
        this.openWeatherApiKey = this.getString(OPEN_WEATHER_API_KEY);
        this.cities = this.getString(CITIES);
        this.pollFrequency = this.getLong(POLL_FREQUENCY);
        this.kafkaTopic = this.getString(KAFKA_TOPIC);
    }

    public static ConfigDef config() {
        return new ConfigDef()
                .define(OPEN_WEATHER_API_KEY, ConfigDef.Type.STRING,
                        ConfigDef.Importance.HIGH, OPEN_WEATHER_API_KEY_DOC)
                .define(CITIES, ConfigDef.Type.STRING,
                        ConfigDef.Importance.HIGH, CITIES_DOC)
                .define(POLL_FREQUENCY, ConfigDef.Type.LONG, 10000L,
                        ConfigDef.Importance.MEDIUM, POLL_FREQUENCY_DOC)
                .define(KAFKA_TOPIC, ConfigDef.Type.STRING,
                        ConfigDef.Importance.HIGH, KAFKA_TOPIC_DOC);
    }

    public String getOpenWeatherApiKey() {
        return openWeatherApiKey;
    }

    public String getCities() {
        return cities;
    }

    public Long getPollFrequency() {
        return pollFrequency;
    }

    public String getKafkaTopic() {
        return kafkaTopic;
    }

	
}