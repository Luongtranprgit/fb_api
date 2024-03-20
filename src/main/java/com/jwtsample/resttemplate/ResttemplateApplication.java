package com.jwtsample.resttemplate;

import com.jwtsample.resttemplate.model.Payment;
import com.jwtsample.resttemplate.model.PaymentTypeEnum;
import com.jwtsample.resttemplate.model.Product;
import com.jwtsample.resttemplate.model.RequestBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
    }

}
