package com.cmonsult.weatherstation.client;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Parse JSON into LocalWeatherData object
                LocalWeatherData localWeatherData = objectMapper.readValue(response.getBody(), LocalWeatherData.class);
                return localWeatherData;
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

