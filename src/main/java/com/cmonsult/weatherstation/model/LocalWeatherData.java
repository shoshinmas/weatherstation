package com.cmonsult.weatherstation.model;

public class LocalWeatherData extends WeatherData {
    private double latitude;
    private double longitude;
    private String timezone;
    private String timezoneAbbreviation;
    private double elevation;
    private double uvIndexMax;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getUvIndexMax() {
        return uvIndexMax;
    }

    public void setUvIndexMax(double uvIndexMax) {
        this.uvIndexMax = uvIndexMax;
    }

}

