package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.service;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDomainService {

    public void processOrder(Order order, BigDecimal pricePerUnit, Optional<BigDecimal> approvalThreshold) {
        order.validate();
        order.calculateTotalPrice(pricePerUnit);

        // Validar si se requiere aprobación adicional
        if (approvalThreshold.isPresent() && order.requiresApproval(approvalThreshold.get())) {
            throw new IllegalArgumentException("Order requires manual approval due to high total price.");
        }

        // Lógica adicional: verificar fechas
        if (order.getCreatedAt().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Order creation date cannot be in the future.");
        }
    }

    public boolean isEligibleForDiscount(Order order, BigDecimal discountThreshold) {
        return order.getTotalPrice() != null && order.getTotalPrice().compareTo(discountThreshold) > 0;
    }
}
