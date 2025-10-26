package com.example.order.application.service;

import com.example.order.application.dto.CreateOrderCommand;
import com.example.order.application.dto.CreateOrderResponse;
import com.example.order.application.port.output.OrderRepository;
import com.example.order.domain.entity.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderApplicationServiceTest {

    @Test
    void shouldCreateOrderSuccessfully() {
        // Mock Repository
        OrderRepository mockRepo = mock(OrderRepository.class);
        when(mockRepo.save(any(Order.class))).thenAnswer(inv -> inv.getArgument(0));

        // Inject service
        OrderApplicationService service = new OrderApplicationService(mockRepo);

        // Tạo command giả lập dữ liệu
        var item = new CreateOrderCommand.OrderItemDto(
                UUID.randomUUID(),
                2,
                BigDecimal.valueOf(25.00),
                BigDecimal.valueOf(50.00)
        );

        var command = new CreateOrderCommand(
                UUID.randomUUID(),
                UUID.randomUUID(),
                BigDecimal.valueOf(50.00),
                List.of(item)
        );

        // Act
        CreateOrderResponse response = service.createOrder(command);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getOrderTrackingId());
        verify(mockRepo, times(1)).save(any(Order.class));

        System.out.println("Application layer Unit Test passed: Order created successfully!");
    }
}
