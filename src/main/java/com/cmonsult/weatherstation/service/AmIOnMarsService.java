package com.cmonsult.weatherstation.service;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import com.cmonsult.weatherstation.model.MarsLikenessScore;
import com.cmonsult.weatherstation.model.MarsWeatherData;
import org.springframework.stereotype.Service;

@Service
public class AmIOnMarsService {

    private final double BASESCORE = 1.0;
    private double temperatureScore;
    private double pressureScore;
    private double uvIndexScore;

    public MarsLikenessScore calculateMarsLikeness(MarsWeatherData marsWeather, LocalWeatherData localWeather) {
        // Implement the ranking algorithm here
        double temperatureScore = calculateTemperatureScore(marsWeather.getMaxTemp(), localWeather.getMaxTemp());
        double pressureScore = calculatePressureScore(marsWeather.getPressure(), localWeather.getPressure());
        double uvIndexScore = calculateUvIndexScore(marsWeather.getLocalUvIrradianceIndex(), localWeather.getUvIndexMax());

        double totalScore = (temperatureScore + pressureScore + uvIndexScore) / 3;

        // Save the result to the database and return it
        MarsLikenessScore score = new MarsLikenessScore(totalScore);
        saveScoreToDatabase(score);
        return score;
    }

    private void saveScoreToDatabase(MarsLikenessScore score) {
    }

    // Methods to calculate individual scores...
    private double calculateUvIndexScore(String localUvIrradianceIndex, double uvIndexMax) {
        return uvIndexScore;
    }

    private double calculatePressureScore(double pressure, double pressure1) {
        return pressureScore;
    }

    private double calculateTemperatureScore(double maxTemp, double maxTemp1) {
        return temperatureScore;
    }


}

