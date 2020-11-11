package testtask.teamvoy.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testtask.teamvoy.model.Item;
import testtask.teamvoy.repository.ItemRepository;
import testtask.teamvoy.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public List<Item> getAllNeededCheapestItem(String name, Long quantity) {
        List<Item> items = repository.findAllByNameOrderByPriceAsc(name);
        List<Item> result = new ArrayList<>();
        int foundQuantity = 0;
        for (Item item : items) {
            Long available = item.getQuantity();
            if (available > 0 && available < quantity - foundQuantity) {
                result.add(new Item(item));
                foundQuantity += available;
                item.setQuantity(0L);
                repository.save(item);
            } else if (available > 0 && available >= quantity - foundQuantity) {
                Item goodItem = new Item(item);
                goodItem.setQuantity(quantity - foundQuantity);
                result.add(goodItem);
                item.setQuantity(available - goodItem.getQuantity());
                repository.save(item);
                return result;
            }
        }
        return result;
    }
}
