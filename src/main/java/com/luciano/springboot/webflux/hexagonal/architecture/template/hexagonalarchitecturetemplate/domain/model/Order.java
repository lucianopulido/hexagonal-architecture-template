package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String productId;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;


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
}
