package com.example.order.application.dto;

import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

public class CreateOrderCommand {

    private UUID customerId;
    private UUID restaurantId;
    private BigDecimal price;
    private List<OrderItemDto> items;

    public CreateOrderCommand() {
    }

    public CreateOrderCommand(UUID customerId, UUID restaurantId, BigDecimal price, List<OrderItemDto> items) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.price = price;
        this.items = items;
    }

    //  Inner class cho item
    public static class OrderItemDto {
        private UUID productId;
        private int quantity;
        private BigDecimal price;
        private BigDecimal subTotal;

        public OrderItemDto() {
        }

        public OrderItemDto(UUID productId, int quantity, BigDecimal price, BigDecimal subTotal) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
            this.subTotal = subTotal;
        }

        public UUID getProductId() { return productId; }
        public void setProductId(UUID productId) { this.productId = productId; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public BigDecimal getPrice() { return price; }
        public void setPrice(BigDecimal price) { this.price = price; }

        public BigDecimal getSubTotal() { return subTotal; }
        public void setSubTotal(BigDecimal subTotal) { this.subTotal = subTotal; }
    }

    public UUID getCustomerId() { return customerId; }
    public void setCustomerId(UUID customerId) { this.customerId = customerId; }

    public UUID getRestaurantId() { return restaurantId; }
    public void setRestaurantId(UUID restaurantId) { this.restaurantId = restaurantId; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public List<OrderItemDto> getItems() { return items; }
    public void setItems(List<OrderItemDto> items) { this.items = items; }
}
