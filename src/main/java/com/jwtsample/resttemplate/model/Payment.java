package com.jwtsample.resttemplate.model;

public class Payment {
    private PaymentTypeEnum payment_type;
    private String payment_provider_name;

    public Payment(PaymentTypeEnum payment_type, String payment_provider_name) {
        this.payment_type = payment_type;
        this.payment_provider_name = payment_provider_name;
    }

    public PaymentTypeEnum getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentTypeEnum payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_provider_name() {
        return payment_provider_name;
    }

    public void setPayment_provider_name(String payment_provider_name) {
        this.payment_provider_name = payment_provider_name;
    }
}
