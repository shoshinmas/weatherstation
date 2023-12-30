package com.cmonsult.weatherstation.service;

import com.cmonsult.weatherstation.client.LocalWeatherClient;
import com.cmonsult.weatherstation.model.LocalWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalWeatherServiceImpl implements WeatherService<LocalWeatherData> {

    @Autowired
    private LocalWeatherClient localWeatherClient;

    @Override
    public LocalWeatherData getWeatherData() {
        // Use localWeatherClient to fetch the data and return it
        return localWeatherClient.getLocalWeatherData();
    }
}
