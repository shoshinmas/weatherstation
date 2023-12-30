package com.cmonsult.weatherstation.controller;

import com.cmonsult.weatherstation.model.LocalWeatherData;
import com.cmonsult.weatherstation.model.MarsWeatherData;
import com.cmonsult.weatherstation.service.LocalWeatherServiceImpl;
import com.cmonsult.weatherstation.service.MarsWeatherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WeatherDashboardController.class)
public class WeatherDashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarsWeatherServiceImpl marsWeatherService;

    @MockBean
    private LocalWeatherServiceImpl localWeatherService;

    @Test
    @WithMockUser // Mock a default user
    public void getMarsWeatherTest() throws Exception {
        MarsWeatherData mockMarsWeather = new MarsWeatherData(); // set up mock data
        // Configure mock behavior
        given(marsWeatherService.getWeatherData()).willReturn(mockMarsWeather);
        mockMarsWeather.setMaxTemp(25.5); // Set sample data

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/mars")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.maxTemp", equalTo(25.5))); // Additional assertions as needed
    }

    @Test
    @WithMockUser // Mock a default user
    public void getLocalWeatherTest() throws Exception {
        LocalWeatherData mockLocalWeather = new LocalWeatherData(); // set up mock data
        // Configure mock behavior
        given(localWeatherService.getWeatherData()).willReturn(mockLocalWeather);

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/local")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", not(empty()))); // Additional assertions as needed
    }
}

