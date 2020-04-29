    package com.openweathermap.kafka.connect;
    
    import com.openweathermap.kafka.connect.model.Weather;
    import kong.unirest.HttpResponse;
    import kong.unirest.Unirest;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class WeatherAPIClient {
    
        private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
        private WeatherAPIConfig config;
    
        public WeatherAPIClient(WeatherAPIConfig weatherAPIConfig) {
            config = weatherAPIConfig;
        }
    
        public List<Weather> getCurrentWeather() {
            return Arrays.stream(config.getCities().split(","))
                    .map(city -> Unirest.get(BASE_URL)
                            .queryString("q", city)
                            .queryString("APPID", config.getOpenWeatherApiKey())
                            .asObject(Weather.class))
                    .map(HttpResponse::getBody)
                    .collect(Collectors.toList());
        }
    }
    
