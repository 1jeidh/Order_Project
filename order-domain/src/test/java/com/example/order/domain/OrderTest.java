package com.example.order.domain;

import com.example.order.domain.entity.*;
import com.example.order.domain.valueobject.Money;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    void testCreateOrder() {
        OrderItem item1 = new OrderItem(UUID.randomUUID(), UUID.randomUUID(), 2, new Money(new java.math.BigDecimal("10.00")));
        OrderItem item2 = new OrderItem(UUID.randomUUID(), UUID.randomUUID(), 1, new Money(new java.math.BigDecimal("15.00")));

        Order order = new Order(UUID.randomUUID(), UUID.randomUUID(), List.of(item1, item2));
        order.validate();
        System.out.println("Order created: " + order.getId() + " total=" + order.getTotalPrice().getAmount());
    }
}