package com.jwtsample.resttemplate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FbService {
    private RestTemplate restTemplate;

    public FbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
