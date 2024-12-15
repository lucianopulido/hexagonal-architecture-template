package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.mapper;


import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.CreateOrderRequest;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.dto.OrderResponse;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.entities.OrderDocument;

public class OrderMapper {

    // DTO → Modelo de Dominio
    public static Order toDomain(CreateOrderRequest request) {
        return new Order(request.getProductId(), request.getQuantity());
    }

    // Modelo de Dominio → DTO
    public static OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setProductId(order.getProductId());
        response.setQuantity(order.getQuantity());
        response.setTotalPrice(order.getTotalPrice());
        response.setCreatedAt(order.getCreatedAt());
        return response;
    }

    // Modelo de Dominio → Entidad (para la base de datos)
    public static OrderDocument toEntity(Order order) {
        OrderDocument document = new OrderDocument();
        document.setId(order.getId());
        document.setProductId(order.getProductId());
        document.setQuantity(order.getQuantity());
        document.setTotalPrice(order.getTotalPrice());
        document.setCreatedAt(order.getCreatedAt());
        return document;
    }

    // Entidad (para la base de datos) → Modelo de Dominio
    public static Order toDomain(OrderDocument document) {
        return new Order(
                document.getId(),
                document.getProductId(),
                document.getQuantity(),
                document.getTotalPrice(),
                document.getCreatedAt()
        );
    }
}
