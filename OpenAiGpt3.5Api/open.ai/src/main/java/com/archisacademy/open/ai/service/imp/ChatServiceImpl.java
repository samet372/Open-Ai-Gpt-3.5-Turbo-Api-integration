package com.archisacademy.open.ai.service.imp;

import com.archisacademy.open.ai.dto.ChatRequest;
import com.archisacademy.open.ai.dto.ChatResponse;
import com.archisacademy.open.ai.service.ChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService {

    private final RestTemplate restTemplate;

    public ChatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String API_URL;
    @Override
    public String sendMessage(String message) {
        ChatRequest chatRequest = new ChatRequest(model, message);
        ChatResponse chatResponse = restTemplate.postForObject(API_URL,chatRequest,ChatResponse.class);
        return chatResponse.getChoices().get(0).getMessage().getContent();
    }
}
