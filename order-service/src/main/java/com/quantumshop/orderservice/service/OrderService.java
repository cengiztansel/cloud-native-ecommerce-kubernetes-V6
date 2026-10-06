package com.quantumshop.orderservice.service;
import com.quantumshop.orderservice.model.OrderEntity;
import com.quantumshop.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderEntity save(OrderEntity order) {
        return repository.save(order);
    }
}
