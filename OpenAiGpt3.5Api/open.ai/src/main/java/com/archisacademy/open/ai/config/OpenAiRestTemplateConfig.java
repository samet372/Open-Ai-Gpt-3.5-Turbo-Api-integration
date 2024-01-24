package com.archisacademy.open.ai.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAiRestTemplateConfig {
    @Value("${openai.api.key}")
    private String OPEN_AI_API_KEY;

    @Bean
    @Qualifier("openAiRestTemplate")
    public RestTemplate openAiRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {request.getHeaders().add("Authorization", "bearer" + OPEN_AI_API_KEY);
        return execution.execute(request,body);
        }));
        return restTemplate;
    }
}
