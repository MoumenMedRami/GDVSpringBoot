package com.example.GDV.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    @Value("${CROSS_ORIGINE}")
    private String CROSS_ORIGINE;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        logger.info("CROSS_ORIGINE : " + CROSS_ORIGINE);

        registry.addMapping("/**")
                .allowedOrigins(CROSS_ORIGINE.split(","))
                .allowedMethods("GET", "POST")
                .allowCredentials(true).maxAge(3600);
    }
}
