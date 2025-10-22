package com.example.order.dataaccess.mapper;

import com.example.order.dataaccess.entity.OrderEntity;
import com.example.order.domain.entity.Order;
import com.example.order.domain.valueobject.Money;
import com.example.order.domain.valueobject.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderDataAccessMapper {

    public OrderEntity toEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setCustomerId(order.getCustomerId());
        entity.setRestaurantId(order.getRestaurantId());
        entity.setTrackingId(order.getTrackingId());
        entity.setPrice(order.getTotalPrice().getAmount());
        entity.setOrderStatus(OrderEntity.OrderStatus.valueOf(order.getStatus().name()));
        entity.setFailureMessages(null);
        entity.setCreatedAt(order.getCreatedAt());
        return entity;
    }

    public Order toDomain(OrderEntity entity) {
        return new Order(
                entity.getCustomerId(),
                entity.getRestaurantId(),
                java.util.Collections.emptyList() // chưa load item ở ví dụ này
        );
    }
}