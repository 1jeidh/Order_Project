package com.example.order.application.dto;

import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

public class CreateOrderCommand {
    private UUID customerId;
    private UUID restaurantId;
    private List<OrderItemDto> items;

    public static class OrderItemDto {
        private UUID productId;
        private int quantity;
        private BigDecimal price;

        public UUID getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public BigDecimal getPrice() { return price; }
    }

    public UUID getCustomerId() { return customerId; }
    public UUID getRestaurantId() { return restaurantId; }
    public List<OrderItemDto> getItems() { return items; }
}