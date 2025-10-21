package com.example.order.domain.entity;

import com.example.order.domain.valueobject.Money;
import java.util.UUID;

public class OrderItem {
    private final UUID id;
    private final UUID productId;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

    public OrderItem(UUID id, UUID productId, int quantity, Money price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = price.multiply(quantity);
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public UUID getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }
}