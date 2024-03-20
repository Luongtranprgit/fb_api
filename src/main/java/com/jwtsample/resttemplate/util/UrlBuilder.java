package com.jwtsample.resttemplate.util;

public class UrlBuilder {
    public static String buildUrl(String apiUrl,String carrier_id,String timestamp, String hmac, String accessToken){
        return String.format("%s?carrier_id=%s&timestamp=%s&hmac=%s&access_token=%s" ,apiUrl, carrier_id, timestamp, hmac, accessToken);
    }
}
//https://graph.facebook.com/oauth/access_token?client_id=959656122334527&client_secret=10c043c0483f55c3a3574fc55013c6de&grant_type=client_credentials
//{"access_token":"959656122334527|gDcVN5FzYasUKZpAHtGB6pR-Go4","token_type":"bearer"}