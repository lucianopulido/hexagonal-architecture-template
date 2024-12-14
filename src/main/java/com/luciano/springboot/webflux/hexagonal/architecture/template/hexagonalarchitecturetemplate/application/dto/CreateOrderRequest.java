package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto;


public class CreateOrderRequest {
    private String productId;
    private Integer quantity;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
