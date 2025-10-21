package com.example.order.domain.entity;

import com.example.order.domain.valueobject.Money;
import com.example.order.domain.valueobject.OrderStatus;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final UUID customerId;
    private final UUID restaurantId;
    private final UUID trackingId;
    private OrderStatus status;
    private final List<OrderItem> items;
    private final Money totalPrice;
    private OffsetDateTime createdAt;
    private String failureMessages;

    public Order(UUID customerId, UUID restaurantId, List<OrderItem> items) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.trackingId = UUID.randomUUID();
        this.items = new ArrayList<>(items);
        this.totalPrice = calculateTotal();
        this.status = OrderStatus.PENDING;
        this.createdAt = OffsetDateTime.now();
    }

    private Money calculateTotal() {
        return items.stream()
                .map(OrderItem::getSubTotal)
                .reduce(Money.ZERO, Money::add);
    }

    public void validate() {
        if (!totalPrice.isGreaterThanZero()) {
            throw new IllegalStateException("Total price must be greater than zero.");
        }
        Money sum = items.stream()
                .map(OrderItem::getSubTotal)
                .reduce(Money.ZERO, Money::add);
        if (!sum.equals(totalPrice)) {
            throw new IllegalStateException("Order total mismatch with item subtotals.");
        }
    }

    public void markPaid() { this.status = OrderStatus.PAID; }
    public void markApproved() { this.status = OrderStatus.APPROVED; }
    public void markCancelled() { this.status = OrderStatus.CANCELLED; }

    // getters
    public UUID getId() { return id; }
    public UUID getTrackingId() { return trackingId; }
    public Money getTotalPrice() { return totalPrice; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return items; }
}