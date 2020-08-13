package com.ly.springcloudlytemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：luoYong
 * @date ：Created in 2020/8/14 0:07
 * @description：ApplicationContextConfig
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
