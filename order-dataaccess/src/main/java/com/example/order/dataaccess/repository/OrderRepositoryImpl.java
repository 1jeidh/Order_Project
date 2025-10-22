package com.example.order.dataaccess.repository;

import com.example.order.application.port.output.OrderRepository;
import com.example.order.dataaccess.entity.OrderEntity;
import com.example.order.dataaccess.mapper.OrderDataAccessMapper;
import com.example.order.domain.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper mapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository,
                               OrderDataAccessMapper mapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Order save(Order order) {
        OrderEntity entity = mapper.toEntity(order);
        OrderEntity saved = orderJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Order> findByTrackingId(UUID trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId)
                .map(mapper::toDomain);
    }
}
