package com.heima.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有的域
        config.addAllowedOrigin("*");
        // 允许所有的请求方法 GET POST DELETE PUT
        config.addAllowedMethod("*");
        // 允许所有的请求头
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        // 匹配所有路径
        source.registerCorsConfiguration("/**",config);
        return new CorsWebFilter(source);
    }
}
