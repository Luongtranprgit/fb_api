package com.jwtsample.resttemplate.service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GenerateHmac {
    private String carrier_id;
    private String timestamp;

    public String getCarrier_id() {
        return carrier_id;
    }

    public void setCarrier_id(String carrier_id) {
        this.carrier_id = carrier_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public static String generateHmac(String timestamp, String carrier_id, String secret) {
        try {
            // Khởi tạo đối tượng Mac với thuật toán SHA-256
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");

            // Chuyển đổi secret key thành đối tượng SecretKeySpec
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");

            // Thiết lập secret key cho đối tượng Mac
            hmacSha256.init(secretKeySpec);

            // Tạo chuỗi dữ liệu để băm (timestamp và carrier_id nối với nhau)
            String dataToHash = timestamp + carrier_id;

            // Băm dữ liệu và lấy chuỗi HMAC
            byte[] hmacBytes = hmacSha256.doFinal(dataToHash.getBytes());

            // Chuyển đổi chuỗi HMAC sang dạng hex string
            StringBuilder hmacStringBuilder = new StringBuilder();
            for (byte b : hmacBytes) {
                hmacStringBuilder.append(String.format("%02x", b));
            }

            // Trả về chuỗi HMAC
            return hmacStringBuilder.toString();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return null;
        }
    }


}
