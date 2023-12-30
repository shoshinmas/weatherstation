package com.cmonsult.weatherstation.service;

import com.cmonsult.weatherstation.client.MarsWeatherClient;
import com.cmonsult.weatherstation.model.MarsWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarsWeatherServiceImpl implements WeatherService<MarsWeatherData> {

    @Autowired
    private MarsWeatherClient marsWeatherClient;

    @Override
    public MarsWeatherData getWeatherData() {
        // Use marsWeatherClient to fetch the data and return it
        return marsWeatherClient.getMarsWeatherData();
    }
}
