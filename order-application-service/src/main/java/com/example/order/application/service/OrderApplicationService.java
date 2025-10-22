package com.example.order.application.service;

import com.example.order.application.dto.*;
import com.example.order.application.port.input.CreateOrderUseCase;
import com.example.order.application.port.output.OrderRepository;
import com.example.order.domain.entity.Order;
import com.example.order.domain.entity.OrderItem;
import com.example.order.domain.valueobject.Money;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderApplicationService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public OrderApplicationService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand command) {
        // 1️⃣ Tạo list OrderItem từ DTO
        List<OrderItem> items = command.getItems().stream()
                .map(i -> new OrderItem(UUID.randomUUID(), i.getProductId(),
                        i.getQuantity(), new Money(i.getPrice())))
                .collect(Collectors.toList());

        // 2️⃣ Tạo Order domain
        Order order = new Order(command.getCustomerId(), command.getRestaurantId(), items);

        // 3️⃣ Validate domain logic
        order.validate();

        // 4️⃣ Lưu vào repository
        Order savedOrder = orderRepository.save(order);

        // 5️⃣ Trả về kết quả
        return new CreateOrderResponse(savedOrder.getTrackingId(), savedOrder.getStatus());
    }
}