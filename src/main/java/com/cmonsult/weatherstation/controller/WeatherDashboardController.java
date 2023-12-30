package com.cmonsult.weatherstation.controller;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import com.cmonsult.weatherstation.model.MarsWeatherData;
import com.cmonsult.weatherstation.service.LocalWeatherServiceImpl;
import com.cmonsult.weatherstation.service.MarsWeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class WeatherDashboardController {
    @Autowired
    private MarsWeatherServiceImpl marsWeatherService;

    @Autowired
    private LocalWeatherServiceImpl localWeatherService;

    @GetMapping("/mars")
    public ResponseEntity<MarsWeatherData> getMarsWeather() {
        MarsWeatherData marsWeatherData = marsWeatherService.getWeatherData();
        return ResponseEntity.ok(marsWeatherData);
    }

    @GetMapping("/local")
    public ResponseEntity<LocalWeatherData> getLocalWeather() {
        LocalWeatherData localWeatherData = localWeatherService.getWeatherData();
        return ResponseEntity.ok(localWeatherData);
    }
}
