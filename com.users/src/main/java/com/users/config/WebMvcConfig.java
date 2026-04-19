package com.users.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import com.users.jwt.util.JwtInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;

    public WebMvcConfig(JwtInterceptor jwtInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/api/**")         // Secure endpoints
                .excludePathPatterns("/auth/**");   // Allow login
    }
}
