package com.quantumshop.orderservice.repository;
import com.quantumshop.orderservice.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
