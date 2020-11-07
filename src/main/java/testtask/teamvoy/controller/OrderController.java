package testtask.teamvoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testtask.teamvoy.dto.OrderRequestDto;
import testtask.teamvoy.mappers.OrderMapper;
import testtask.teamvoy.model.Order;
import testtask.teamvoy.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderMapper.mapDtoToOrder(orderRequestDto);
        orderService.save(order);
    }
}
