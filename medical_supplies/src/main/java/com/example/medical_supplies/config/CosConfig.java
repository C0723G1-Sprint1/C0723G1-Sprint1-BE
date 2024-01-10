package com.example.medical_supplies.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The CorsConfig class is a @Configuration for CORS configuration
 * Implements WebMvcConfigurer to customize configuration
 * @author: ThanhPV
 * @date: 12/12/2023
 */
public class CosConfig implements WebMvcConfigurer {
    /**
     * The addCorsMappings method configures CORS for the "/api/**" mappings.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param registry CorsRegistry object for CORS configuration.
     */
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH")
                .allowedHeaders("*");
    }
}
