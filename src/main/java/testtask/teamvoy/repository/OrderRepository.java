package testtask.teamvoy.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import testtask.teamvoy.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByTimeBefore(LocalDateTime localDateTime);
}
