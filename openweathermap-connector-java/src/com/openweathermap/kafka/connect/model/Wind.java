package com.openweathermap.kafka.connect.model;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private Float speed;

    @SerializedName("deg")
    private Integer deg;

    public Wind() {}

    public Wind(Float speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }
}
