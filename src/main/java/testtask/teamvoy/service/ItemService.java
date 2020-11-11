package testtask.teamvoy.service;

import java.util.List;
import testtask.teamvoy.model.Item;

public interface ItemService {

    Item findById(Long id);

    Item save(Item item);

    List<Item> getAllNeededCheapestItem(String name, Long quantity);
}
