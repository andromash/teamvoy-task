package testtask.teamvoy.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testtask.teamvoy.dto.OrderRequestDto;
import testtask.teamvoy.dto.OrderResponseDto;
import testtask.teamvoy.model.Order;
import testtask.teamvoy.service.ItemService;

@Component
public class OrderMapper {
    private final ItemService itemService;

    @Autowired
    public OrderMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    public Order mapDtoToOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setItem(itemService.findById(orderRequestDto.getItemId()));
        order.setPrice(orderRequestDto.getPrice());
        order.setQuantity(orderRequestDto.getQuantity());
        return order;
    }

    public OrderResponseDto mapOrderToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setItem(order.getItem().getName());
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setQuantity(order.getQuantity());
        return orderResponseDto;
    }
}
