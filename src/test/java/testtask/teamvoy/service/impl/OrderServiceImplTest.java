package testtask.teamvoy.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import testtask.teamvoy.model.Item;
import testtask.teamvoy.model.Order;
import testtask.teamvoy.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        Order order = new Order();
        order.setTime(LocalDateTime.now());
        order.setQuantity(2);
        order.setPrice(10L);
        order.setItem(new Item());

        orderService.save(order);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void getAll() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> orderList = orderService.getAll();

        Assert.assertEquals(orders, orderList);
    }

    @Test
    void deleteOld() {
        Order order = new Order();
        order.setTime(LocalDateTime.now().minusMinutes(12));
        order.setQuantity(2);
        order.setPrice(10L);
        order.setItem(new Item());
        orderRepository.save(order);
        when(orderRepository.findByTimeBefore(LocalDateTime.now()
                .minusMinutes(10))).thenReturn(List.of(order));

        orderService.deleteOld();
        List<Order> all = orderRepository.findAll();
        Assert.assertEquals(all, new ArrayList<>());
    }
}
