package testtask.teamvoy.service;

import java.util.List;
import testtask.teamvoy.model.Order;

public interface OrderService {
    Order save(Order order);

    List<Order> getAll();

    void deleteOld();
}
