package com.cmonsult.weatherstation.client;

import com.cmonsult.weatherstation.model.MarsWeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsWeatherClientTest {

    @Autowired
    private MarsWeatherClient marsWeatherClient;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetMarsWeatherData() {
        // Call the actual API and test the response
        MarsWeatherData marsWeatherData = marsWeatherClient.getMarsWeatherData();

        // Assertions
        assertNotNull(marsWeatherData);
        // Add more assertions based on the actual response data
    }
}
