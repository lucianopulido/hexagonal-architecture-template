package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.entities;



import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDocument {
    @Id
    private String id;
    private String productId;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;


    public static OrderDocument fromDomain(Order order) {
        OrderDocument document = new OrderDocument();
        document.id = order.getId();
        document.productId = order.getProductId();
        document.quantity = order.getQuantity();
        document.totalPrice = order.getTotalPrice();
        document.createdAt = order.getCreatedAt();
        return document;
    }

    public static Order toDomain(OrderDocument document) {
        Order order = new Order(document.productId, document.quantity);
        order.setId(document.id);
        order.setTotalPrice(document.totalPrice);
        order.setCreatedAt(document.createdAt);
        return order;
    }

}
