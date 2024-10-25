package com.example.weathermonitoringsystem.repository;

import com.example.weathermonitoringsystem.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

}
