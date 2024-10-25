package com.example.weathermonitoringsystem.controller;

import com.example.weathermonitoringsystem.model.WeatherData;
import com.example.weathermonitoringsystem.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public List<WeatherData> getWeatherData() {
        return weatherService.getAllWeatherData();
    }
}
