package com.jwtsample.resttemplate.service;

import com.jwtsample.resttemplate.util.UrlBuilder;
import org.springframework.stereotype.Service;

@Service
public class GenerateUrlService {
    public String generateUrl(String secret, String timestamp, String carrierId, String accessToken) {

        String apiUrl = "https://graph.facebook.com/carrier_external_sales";
        // Tạo HMAC
        String hmac = GenerateHmacService.generateHmac(timestamp, carrierId, secret);
        // Xây dựng URL
        return UrlBuilder.buildUrl(apiUrl, carrierId, timestamp, hmac, accessToken);

    }
}
