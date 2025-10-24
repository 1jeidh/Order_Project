package com.example.order.container.rest;

import com.example.order.application.dto.CreateOrderCommand;
import com.example.order.application.dto.CreateOrderResponse;
import com.example.order.application.service.OrderApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(
            @Valid @RequestBody CreateOrderCommand createOrderCommand) {

        log.info("Creating order for customer: {} at restaurant: {}",
                createOrderCommand.getCustomerId(),
                createOrderCommand.getRestaurantId());

        CreateOrderResponse response = orderApplicationService.createOrder(createOrderCommand);

        log.info("Order created with tracking id: {}", response.getOrderTrackingId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}