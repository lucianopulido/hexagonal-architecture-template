package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Order {
    private String id;
    private String productId;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;

    public Order() {
    }

    public Order(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = LocalDateTime.now();
    }


    public void validate() {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
    }

    public void calculateTotalPrice(BigDecimal pricePerUnit) {
        this.totalPrice = pricePerUnit.multiply(BigDecimal.valueOf(quantity));
    }

    public boolean requiresApproval(BigDecimal approvalThreshold) {
        return totalPrice != null && totalPrice.compareTo(approvalThreshold) > 0;
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
