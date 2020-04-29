package com.openweathermap.kafka.connect.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Weather {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("weather")
    private List<WeatherDetails> weather;

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    public Weather() {}

    public Weather(Long id, String name, List<WeatherDetails> weather, Main main, Wind wind) {
        this.id = id;
        this.name = name;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherDetails> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDetails> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weather=" + weather +
                ", main=" + main +
                ", wind=" + wind +
                '}';
    }
}
