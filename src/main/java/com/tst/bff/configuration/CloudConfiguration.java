package com.tst.bff.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yaxio
 */
@Configuration
public class CloudConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplateBuilder builder=new RestTemplateBuilder();
        return builder.build();
    }
}
