package com.example.order.application.port.input;

import com.example.order.application.dto.CreateOrderCommand;
import com.example.order.application.dto.CreateOrderResponse;

public interface CreateOrderUseCase {
    CreateOrderResponse createOrder(CreateOrderCommand command);
}