package com.cmonsult.weatherstation.client;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import com.cmonsult.weatherstation.model.MarsWeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(LocalWeatherClient.class)
public class LocalWeatherClientTest {

    @Autowired
    private LocalWeatherClient localWeatherClient;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        server = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetLocalWeatherData() {
        // Call the actual API and test the response
        LocalWeatherData localWeatherData = localWeatherClient.getLocalWeatherData();

        // Assertions
        assertNotNull(localWeatherData);
        // Add more assertions based on the actual response data
    }
}

