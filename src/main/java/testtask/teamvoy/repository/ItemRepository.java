package testtask.teamvoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testtask.teamvoy.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
