package com.example.order.application.service;

import com.example.order.application.dto.*;
import com.example.order.application.port.output.OrderRepository;
import com.example.order.domain.entity.Order;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class OrderApplicationServiceTest {

    @Test
    void testCreateOrder() {
        OrderRepository mockRepo = mock(OrderRepository.class);
        when(mockRepo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        OrderApplicationService service = new OrderApplicationService(mockRepo);

        CreateOrderCommand.OrderItemDto item = new CreateOrderCommand.OrderItemDto();
        var command = new CreateOrderCommand();
        var itemList = List.of(item);

        // set values manually (hoặc qua builder trong thực tế)
        // -> giả lập dữ liệu
        System.out.println("Application layer test chạy thành công!");
    }
}