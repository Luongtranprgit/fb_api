package com.jwtsample.resttemplate.request;


import com.jwtsample.resttemplate.model.EventTypeEnum;
import com.jwtsample.resttemplate.model.InventoryTypeEnum;
import com.jwtsample.resttemplate.model.Payment;

public class FbRequest {
    private String tid;
    private String msisdn;
    private EventTypeEnum event;
    private String result_code;
    private String result_message;
    private InventoryTypeEnum inventory_type;
    private Payment payment;



}
