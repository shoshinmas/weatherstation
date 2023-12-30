package com.cmonsult.weatherstation.client;

import com.cmonsult.weatherstation.model.MarsWeatherData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Parse JSON into MarsWeatherData object
                return objectMapper.readValue(response.getBody(), MarsWeatherData.class);
            } catch (Exception e) {
                // Handle parsing exception (e.g., log the error)
                e.printStackTrace();
            }
        }

        // Return null if there was an error or no response
        return null;
    }


    @Scheduled(cron = "@daily") // Or use fixedRate or fixedDelay as per your requirement
    public void updateWeatherData() {
        // Code to fetch and update weather data daily
    }

}

