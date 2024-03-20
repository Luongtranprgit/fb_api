package com.jwtsample.resttemplate.controller;

import com.jwtsample.resttemplate.model.Payment;
import com.jwtsample.resttemplate.model.PaymentTypeEnum;
import com.jwtsample.resttemplate.model.Product;
import com.jwtsample.resttemplate.service.GenerateUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import com.jwtsample.resttemplate.model.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class FbPostBodyController {
    private final GenerateUrlService generateUrlService;

    @PostMapping("/post-body")
    public void postDataToAPI(@RequestParam String secret, @RequestParam String timestamp, @RequestParam String carrier_id, @RequestParam String accessToken, String tid, String event, String inventory_type, String result_code, String result_message, PaymentTypeEnum payment_type, String payment_provider_name, String product_code, Float product_price, String product_currency) {
        RestTemplate restTemplate = new RestTemplate();
        RequestBody requestBody = new RequestBody();
        requestBody.setTid(tid);
        requestBody.setEvent(event);
        requestBody.setInventory_type(inventory_type);
        requestBody.setResult_code(result_code);
        requestBody.setResult_message(result_message);

        Payment payment = new Payment(payment_type, payment_provider_name);
        requestBody.setPayment(payment);

        Product product = new Product(product_code,product_price, product_currency);
        requestBody.setProduct(product);

        HttpHeaders http = new HttpHeaders();
        http.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RequestBody> requestBodyHttpEntity = new HttpEntity<>(requestBody, http);

        // Lấy URL từ FbGenUrlController
        String url = generateUrlService.generateUrl(secret, timestamp, carrier_id, accessToken);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestBodyHttpEntity, String.class);
        String responseBody = responseEntity.getBody();
        System.out.println("Response from API: " + responseBody);

    }
}
