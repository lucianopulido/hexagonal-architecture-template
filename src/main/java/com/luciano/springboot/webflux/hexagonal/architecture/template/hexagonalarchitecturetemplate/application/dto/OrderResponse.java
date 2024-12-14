package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrderResponse {
    private String id;
    private String productId;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;

    public OrderResponse() {
    }

    public OrderResponse(String id, String productId, Integer quantity, BigDecimal totalPrice, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
