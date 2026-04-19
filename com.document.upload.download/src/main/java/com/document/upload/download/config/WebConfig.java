package com.document.upload.download.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // This tells Spring Boot: any URL (/**) maps to files in uploads/
        registry.addResourceHandler("/**")
                .addResourceLocations("file:uploads/"); // Folder path relative to project root
    }
}

