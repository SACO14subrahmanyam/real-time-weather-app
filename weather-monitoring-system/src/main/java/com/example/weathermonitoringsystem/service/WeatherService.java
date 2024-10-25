package com.example.weathermonitoringsystem.service;

import com.example.weathermonitoringsystem.dto.WeatherResponse;
import com.example.weathermonitoringsystem.model.WeatherData;
import com.example.weathermonitoringsystem.repository.WeatherDataRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final WeatherDataRepository weatherDataRepository;
    private final RestTemplate restTemplate;

    public WeatherService(WeatherDataRepository weatherDataRepository, RestTemplate restTemplate) {
        this.weatherDataRepository = weatherDataRepository;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    @Scheduled(fixedRate = 300000) // Every 5 minutes
    public void fetchWeatherData() {
        String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

        for (String city : cities) {
            String url = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city + "&aqi=no";
            try {
                WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
                if (response != null && response.getCurrent() != null) {
                    WeatherData weatherData = new WeatherData();
                    weatherData.setCity(city);
                    weatherData.setTemperature(response.getCurrent().getTemp_c());
                    weatherData.setHumidity(response.getCurrent().getHumidity());
                    weatherData.setWindSpeed(response.getCurrent().getWind_kph());
                    weatherData.setWeatherCondition(response.getCurrent().getCondition().getText());
                    weatherData.setDateTime(String.valueOf(response.getCurrent().getLast_updated_epoch()));

                    weatherDataRepository.save(weatherData);
                    logger.info("Weather data for {} saved successfully.", city);
                }
            } catch (Exception e) {
                logger.error("Error fetching weather data for {}: {}", city, e.getMessage());
            }
        }
    }

    public List<WeatherData> getAllWeatherData() {
        return weatherDataRepository.findAll();
    }
}
