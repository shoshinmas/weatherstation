package com.cmonsult.weatherstation.client;

import com.cmonsult.weatherstation.model.MarsWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsWeatherClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mars.weather.api.url}")
    private String marsWeatherApiUrl;

    public MarsWeatherData getMarsWeatherData() {
        ResponseEntity<String> response = restTemplate.getForEntity(marsWeatherApiUrl, String.class);
        // Parse the JSON from response.getBody() to MarsWeatherData
        // Handle any parsing exceptions and return the data
        return null;
    }
}

