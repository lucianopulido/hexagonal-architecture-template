package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.adapter.out.notification;


import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out.NotificationPort;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationAdapter implements NotificationPort {

    @Override
    public void sendOrderNotification(Order order) {
        // Simulación de envío de correo
        System.out.println("Notificación enviada para el pedido: " + order.getId());
    }
}