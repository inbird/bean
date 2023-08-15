package com.example.bean.config;

import com.example.bean.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Hello helloBean(){
        return new HelloKoreaImpl();
    }

    @Bean
    public Discount discountBean(){
        return new Discount50Impl();
    }

    @Bean
    public Pay payBean(){
        return new PayImpl(helloBean(), discountBean());
    }
}
