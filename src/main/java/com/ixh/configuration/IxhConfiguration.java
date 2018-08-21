package com.ixh.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class IxhConfiguration {
	
	@Value( "${app.allow.origins}" )
	private String allowOrigins;
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		System.out.println("allow origin: "+allowOrigins);
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins(allowOrigins);
            }
        };
    }
}
