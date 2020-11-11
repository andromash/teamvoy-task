package testtask.teamvoy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testtask.teamvoy.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByName(String name);

    List<Item> findAllByNameOrderByPriceAsc(String name);
}
