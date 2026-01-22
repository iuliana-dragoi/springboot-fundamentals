package com.example.springboot.config;

import com.example.springboot.service.GreetingService;
import com.example.springboot.service.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GreetingService greetingService() {
        // This is the Factory Method
        return new GreetingServiceImpl();
    }
}
