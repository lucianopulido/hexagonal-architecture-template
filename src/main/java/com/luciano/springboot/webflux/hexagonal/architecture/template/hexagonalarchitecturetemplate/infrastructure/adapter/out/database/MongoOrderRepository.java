package com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.adapter.out.database;

import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.application.mapper.OrderMapper;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.model.Order;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.domain.port.out.OrderRepositoryPort;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.entities.OrderDocument;
import com.luciano.springboot.webflux.hexagonal.architecture.template.hexagonalarchitecturetemplate.infrastructure.repositories.SpringDataMongoOrderRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MongoOrderRepository implements OrderRepositoryPort {

    private final SpringDataMongoOrderRepository repository;

    public MongoOrderRepository(SpringDataMongoOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Order> saveOrder(OrderDocument order) {
        return repository.save(order).map(OrderMapper::toDomain);
    }

    @Override
    public Mono<Order> findOrderById(String id) {
        return repository.findById(id).map(OrderMapper::toDomain);
    }
}