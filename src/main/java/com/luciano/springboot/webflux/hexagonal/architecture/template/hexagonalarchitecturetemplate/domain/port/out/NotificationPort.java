package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out;


import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;

public interface NotificationPort {
    void sendOrderNotification(Order order);
}
