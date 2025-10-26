package com.example.order.domain;

import com.example.order.domain.entity.Order;
import com.example.order.domain.entity.OrderItem;
import com.example.order.domain.valueobject.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    @DisplayName("Should create valid order with correct total price")
    void shouldCreateOrderWithValidItems() {
        OrderItem item1 = new OrderItem(UUID.randomUUID(), UUID.randomUUID(), 2, new Money(BigDecimal.valueOf(10.00)));
        OrderItem item2 = new OrderItem(UUID.randomUUID(), UUID.randomUUID(), 1, new Money(BigDecimal.valueOf(15.00)));

        Order order = new Order(UUID.randomUUID(), UUID.randomUUID(), List.of(item1, item2));
        order.validate();

        assertNotNull(order.getId(), "Order ID should not be null");
        assertEquals(0, order.getTotalPrice().getAmount().compareTo(BigDecimal.valueOf(35.00)), "Total price should be correct");
        assertTrue(order.getItems().size() > 0, "Order should contain items");
    }

    @Test
    @DisplayName("Should throw exception when item has negative price")
    void shouldThrowExceptionIfPriceIsNegative() {
        OrderItem badItem = new OrderItem(UUID.randomUUID(), UUID.randomUUID(), 1, new Money(BigDecimal.valueOf(-5.00)));

        assertThrows(
                IllegalArgumentException.class,
                () -> new Order(UUID.randomUUID(), UUID.randomUUID(), List.of(badItem)),
                "Expected exception for negative price"
        );
    }

    @Test
    @DisplayName("Should throw exception when order has no items")
    void shouldFailIfNoItemsProvided() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Order(UUID.randomUUID(), UUID.randomUUID(), List.of()),
                "Expected exception for empty order"
        );
    }
}