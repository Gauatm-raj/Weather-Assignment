package com.example.weather.Weather.Information.Detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String apiKey = "cb8f7d9ede8e9cfbbb40b7c426bbdc59";

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherByCity(String city)
    {
        try{
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        }
        catch (Exception e){
            return "not found";
        }
    }
}
