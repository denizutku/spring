package com.example.demo;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
