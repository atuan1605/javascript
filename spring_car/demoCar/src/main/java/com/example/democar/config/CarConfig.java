package com.example.democar.config;

import com.example.democar.service.CarService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
    @Bean
    public CarService carService(){
        return new CarService("MOCK_DATA.csv");
    }
}
