package com.tuling.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by smlz on 2019/11/18.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate( ) {
        return new RestTemplate();
    }


}
