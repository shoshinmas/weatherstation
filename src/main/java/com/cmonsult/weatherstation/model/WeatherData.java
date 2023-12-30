package com.cmonsult.weatherstation.model;

import java.time.LocalDate;

public class WeatherData {

    // Common attributes, e.g., min and max temperature, pressure
    private LocalDate date;
    private double minTemp;
    private double maxTemp;
    private double pressure;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

}
