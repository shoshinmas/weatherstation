package com.cmonsult.weatherstation.repository;

import com.cmonsult.weatherstation.model.WeatherData;
import org.springframework.data.repository.CrudRepository;

public interface WeatherDataRepository extends CrudRepository<WeatherData, Long> {
    // Custom query methods if needed, for example:
    // List<WeatherData> findByDate(LocalDate date);
}

