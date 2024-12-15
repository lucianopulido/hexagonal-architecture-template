package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.usecase;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.CreateOrderRequest;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.OrderResponse;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.mapper.OrderMapper;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.in.OrderUseCase;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out.NotificationPort;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out.OrderRepositoryPort;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

import static com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.mapper.OrderMapper.toEntity;

@Service
public class OrderUseCaseImpl implements OrderUseCase {

    private final OrderRepositoryPort orderRepository;
    private final NotificationPort notificationPort;
    private final OrderDomainService orderDomainService;

    public OrderUseCaseImpl(OrderRepositoryPort orderRepository, NotificationPort notificationPort) {
        this.orderRepository = orderRepository;
        this.notificationPort = notificationPort;
        this.orderDomainService = new OrderDomainService();
    }

    @Override
    public Mono<OrderResponse> createOrder(CreateOrderRequest request) {
        // 1. Convertir DTO en modelo de dominio
        Order order = new Order(request.getProductId(), request.getQuantity());

        // 2. Aplicar lógica de negocio
        BigDecimal pricePerUnit = getPriceFromCatalog(order.getProductId());
        orderDomainService.processOrder(order, pricePerUnit, Optional.of(BigDecimal.valueOf(1000)));

        // 3. Persistir y convertir a DTO de respuesta
        return orderRepository.saveOrder(toEntity(order))
                .doOnSuccess(notificationPort::sendOrderNotification)
                .map(OrderMapper::toResponse);
    }

    @Override
    public Mono<OrderResponse> getOrderById(String id) {
        return orderRepository.findOrderById(id).map(OrderMapper::toResponse);
    }

    private BigDecimal getPriceFromCatalog(String productId) {
        return BigDecimal.valueOf(10.0); // Simulación
    }
}
