package com.openweathermap.kafka.connect.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private Float temp;

    @SerializedName("pressure")
    private Integer pressure;

    @SerializedName("humidity")
    private Integer humidity;

    @SerializedName("temp_min")
    private Float tempMin;

    @SerializedName("temp_max")
    private Float tempMax;

    public Main() {}

    public Main(Float temp, Integer pressure, Integer humidity, Float tempMin, Float temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = temp_max;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getTempMin() {
        return tempMin;
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Float getTempMax() {
        return tempMax;
    }

    public void setTempMax(Float temp_max) {
        this.tempMax = temp_max;
    }
}
