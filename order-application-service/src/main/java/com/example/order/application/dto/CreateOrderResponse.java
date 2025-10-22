package com.example.order.application.dto;

import java.util.UUID;
import com.example.order.domain.valueobject.OrderStatus;

public class CreateOrderResponse {
    private UUID orderTrackingId;
    private OrderStatus orderStatus;

    public CreateOrderResponse(UUID orderTrackingId, OrderStatus orderStatus) {
        this.orderTrackingId = orderTrackingId;
        this.orderStatus = orderStatus;
    }

    public UUID getOrderTrackingId() { return orderTrackingId; }
    public OrderStatus getOrderStatus() { return orderStatus; }
}