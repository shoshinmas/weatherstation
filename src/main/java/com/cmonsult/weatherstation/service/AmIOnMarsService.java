package com.cmonsult.weatherstation.service;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import com.cmonsult.weatherstation.model.MarsLikenessScore;
import com.cmonsult.weatherstation.model.MarsWeatherData;
import com.cmonsult.weatherstation.model.UVIndex;
import com.cmonsult.weatherstation.repository.MarsLikenessScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AmIOnMarsService {

    @Autowired
    private MarsLikenessScoreRepository scoreRepository;

    public MarsLikenessScore calculateAndSaveMarsLikeness(MarsWeatherData marsWeather, LocalWeatherData localWeather) {
        double likenessScore = calculateMarsLikeness(marsWeather, localWeather);
        MarsLikenessScore score = new MarsLikenessScore(LocalDate.now(), likenessScore);
        return scoreRepository.save(score);
    }

    private double calculateMarsLikeness(MarsWeatherData marsWeather, LocalWeatherData localWeather) {
        // Normalize temperature and pressure as before
        double normMarsTemp = normalize(marsWeather.getMaxTemp(), -100, 30);
        double normLocalTemp = normalize(localWeather.getMaxTemp(), -100, 30);

        double normMarsPressure = normalize(marsWeather.getPressure(), 0, 1000);
        double normLocalPressure = normalize(localWeather.getPressure(), 0, 1000);

        // Convert Mars UV index from String to Enum and then to a score
        UVIndex marsUvIndex = UVIndex.fromString(marsWeather.getLocalUvIrradianceIndex());
        double marsUvScore = uvIndexToScore(marsUvIndex); // This will align with local UV score

        // Assume local UV index is a numerical value directly
        double localUvScore = localWeather.getUvIndexMax(); // Directly use the numerical UV index from local data

        // Calculate Euclidean distance with the new UV scores
        double distance = Math.sqrt(
                Math.pow(normMarsTemp - normLocalTemp, 2) +
                        Math.pow(normMarsPressure - normLocalPressure, 2) +
                        Math.pow(marsUvScore - localUvScore, 2)
        );

        // Convert distance to a likeness score (smaller distance -> higher score)
        return 1 / (1 + distance);
    }

    private double normalize(double value, double min, double max) {
        return (value - min) / (max - min);
    }

    private double uvIndexToScore(UVIndex uvIndex) {
        // Assign numerical scores that align with the local UV index scale
        switch (uvIndex) {
            case LOW:
                return 1; // Or whatever numerical value represents "Low" in the local data
            case MODERATE:
                return 4; // Or value for "Moderate"
            case HIGH:
                return 6; // Or value for "High"
            case VERY_HIGH:
                return 9; // Or value for "Very High"
            case EXTREME:
                return 11; // Or value for "Extreme"
            default:
                return 0; // or handle unexpected values appropriately
        }
    }
}
