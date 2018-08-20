package com.pollingapp.thebloez.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by thebloez on 04/06/18.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    // enable CORS for all path
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
