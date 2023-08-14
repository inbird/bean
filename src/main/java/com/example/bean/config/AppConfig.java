package com.example.bean.config;

import com.example.bean.test.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
//@Configuration
public class AppConfig {

    @Bean
    public Hello getHello(){
        return new HelloKoreaImpl();
    }

    @Bean
    public Hello getHello2(){
        return new HelloKoreaImpl();
    }

    @Bean
    public Discount getDiscount(){
        return new Discount50Impl();
    }

    @Bean
    public Pay getPay(){
        return new PayImpl(getHello(), getDiscount());
    }
}
