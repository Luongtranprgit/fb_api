package com.jwtsample.resttemplate.controller;

import com.jwtsample.resttemplate.service.GenerateUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FbGenUrlController {

    private final GenerateUrlService generateUrlService;
    @PostMapping("/postdata")
    public String postData(
            @RequestParam String secret,
            @RequestParam String timestamp,
            @RequestParam String carrier_id,
            @RequestParam String accessToken
    ){
        // Xây dựng URL
        String url = generateUrlService.generateUrl(secret, timestamp, carrier_id, accessToken);
        System.out.println(url);
        return url;
    }

}
