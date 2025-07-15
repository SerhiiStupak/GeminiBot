package com.example.Gemini;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfiguration {

    @Bean
    public GeminiClient geminiClient(
            @Value("${gemini.token}") String apiKey,
            RestTemplateBuilder restTemplateBuilder
    ) {
        return new GeminiClient(apiKey, restTemplateBuilder.build());
    }
}
