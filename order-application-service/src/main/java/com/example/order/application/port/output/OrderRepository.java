package com.example.order.application.port.output;

import com.example.order.domain.entity.Order;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findByTrackingId(UUID trackingId);
}