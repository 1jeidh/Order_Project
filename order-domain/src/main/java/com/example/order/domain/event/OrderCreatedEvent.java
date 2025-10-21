package com.example.order.domain.event;

import com.example.order.domain.entity.Order;
import java.time.OffsetDateTime;

public class OrderCreatedEvent implements DomainEvent<Order> {
    private final Order order;
    private final OffsetDateTime createdAt;

    public OrderCreatedEvent(Order order, OffsetDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    @Override
    public Order getEntity() {
        return order;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}