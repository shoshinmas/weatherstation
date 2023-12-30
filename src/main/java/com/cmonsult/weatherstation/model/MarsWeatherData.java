package com.cmonsult.weatherstation.model;

public class MarsWeatherData extends WeatherData {
    private String terrestrialDate;
    private int sol;
    private String season;
    private String pressureString;
    private String atmoOpacity;
    private String sunrise;
    private String sunset;
    private String localUvIrradianceIndex;

    public String getTerrestrialDate() {
        return terrestrialDate;
    }

    public void setTerrestrialDate(String terrestrialDate) {
        this.terrestrialDate = terrestrialDate;
    }

    public int getSol() {
        return sol;
    }

    public void setSol(int sol) {
        this.sol = sol;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getPressureString() {
        return pressureString;
    }

    public void setPressureString(String pressureString) {
        this.pressureString = pressureString;
    }

    public String getAtmoOpacity() {
        return atmoOpacity;
    }

    public void setAtmoOpacity(String atmoOpacity) {
        this.atmoOpacity = atmoOpacity;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getLocalUvIrradianceIndex() {
        return localUvIrradianceIndex;
    }

    public void setLocalUvIrradianceIndex(String localUvIrradianceIndex) {
        this.localUvIrradianceIndex = localUvIrradianceIndex;
    }

}

