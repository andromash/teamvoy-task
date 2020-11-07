package testtask.teamvoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testtask.teamvoy.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
