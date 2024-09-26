package com.example.weather.Weather.Information.Detail.controller;

import com.example.weather.Weather.Information.Detail.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        try{
            String weatherData = weatherService.getWeatherByCity(city);
            System.out.println(weatherData);
            return ResponseEntity.ok(weatherData);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}




