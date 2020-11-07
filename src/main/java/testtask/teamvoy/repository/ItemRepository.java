package testtask.teamvoy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import testtask.teamvoy.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByName(String name);
}
