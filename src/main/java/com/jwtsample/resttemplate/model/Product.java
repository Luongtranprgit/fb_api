    package com.jwtsample.resttemplate.model;

    public class Product {
        private String product_code;
        private Float product_price;
        private String product_currency;

        public Product(String product_code,Float product_price, String product_currency) {
            this.product_code = product_code;
            this.product_price = product_price;
            this.product_currency = product_currency;
        }

        public String getProduct_code() {
            return product_code;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public Float getProduct_price() {
            return product_price;
        }

        public void setProduct_price(Float product_price) {
            this.product_price = product_price;
        }

        public String getProduct_currency() {
            return product_currency;
        }

        public void setProduct_currency(String product_currency) {
            this.product_currency = product_currency;
        }
    }
