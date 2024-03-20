package com.jwtsample.resttemplate;

import com.jwtsample.resttemplate.model.Payment;
import com.jwtsample.resttemplate.model.PaymentTypeEnum;
import com.jwtsample.resttemplate.model.Product;
import com.jwtsample.resttemplate.model.RequestBody;
import com.jwtsample.resttemplate.service.GenerateHmac;
import com.jwtsample.resttemplate.util.UrlBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = "https://graph.facebook.com/carrier_external_sales";
//        String carrier_id = "1462";
//        String timestamp = "1568837744";
        String secret = "10c043c0483f55c3a3574fc55013c6de";
        GenerateHmac generateHmac = new GenerateHmac();

        String hmac = generateHmac.generateHmac(generateHmac.getTimestamp(), generateHmac.getCarrier_id(), secret);
        String accessToken = "959656122334527|gDcVN5FzYasUKZpAHtGB6pR-Go4";
        String url = UrlBuilder.buildUrl(apiUrl, generateHmac.getCarrier_id(), generateHmac.getTimestamp(), hmac, accessToken);
        System.out.println(url);

        RequestBody requestBody = new RequestBody();
        requestBody.setTid("ATjxtPq3GZiJQaq_aopM7u544_MhK_V-WtHwYF6yPnwuCEScbRzem-vDspAqmxxr4bA");
        requestBody.setEvent("purchase");
        requestBody.setInventory_type("DATA_PACK");
        requestBody.setResult_code("0");
        requestBody.setResult_message("success");

        Payment payment = new Payment(PaymentTypeEnum.CREDIT_CARD, "MASTERCARD");
        requestBody.setPayment(payment);

        Product product = new Product("62", Float.valueOf("6"), "USD");
        requestBody.setProduct(product);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RequestBody> requestEntity = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        System.out.println("Response from API: " + responseBody);

    }

}
