package testtask.teamvoy.service;

import testtask.teamvoy.model.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    List<Order> getAll();

    void deleteOld();
}
