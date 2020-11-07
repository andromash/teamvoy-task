package testtask.teamvoy.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import testtask.teamvoy.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById(Long id);
}
