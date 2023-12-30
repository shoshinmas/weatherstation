package com.cmonsult.weatherstation.client;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocalWeatherClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${local.weather.api.url}")
    private String localWeatherApiUrl;

    @Value("${local.weather.api.latitude}")
    private String latitude;

    @Value("${local.weather.api.longitude}")
    private String longitude;

    @Value("${local.weather.api.params}")
    private String params;

    public LocalWeatherData getLocalWeatherData() {
        String urlWithParams = localWeatherApiUrl + "?latitude=" + latitude + "&longitude=" + longitude + "&" + params;
        ResponseEntity<String> response = restTemplate.getForEntity(urlWithParams, String.class);
        // Parse the JSON from response.getBody() to LocalWeatherData
        // Handle any parsing exceptions and return the data
        return null;
    }

    @Scheduled(cron = "@daily") // Or use fixedRate or fixedDelay as per your requirement
    public void updateWeatherData() {
        // Code to fetch and update weather data daily
    }

}

