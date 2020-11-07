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

    private Optional<Item> getCheapItem(String name) {
        return repository.findByName(name).stream()
                .filter(item -> item.getQuantity() > 0)
                .min(Comparator.comparing(Item::getPrice));
    }

    @Override
    public List<Item> getAllNeededCheapItem(String name, Long quantity) {
        List<Item> items = new ArrayList<>();
        long foundQuantity = 0;
        while (foundQuantity < quantity) {
            Optional<Item> itemOptional = getCheapItem(name);
            if(itemOptional.isEmpty()) {
                return items;
            }
            Item item = itemOptional.get();
            Long itemQuantity = item.getQuantity();
            if (itemQuantity >= quantity) {
                item.setQuantity(itemQuantity - quantity);
                items.add(item);
                repository.save(item);
                break;
            }
            foundQuantity = foundQuantity + itemQuantity;
            items.add(item);
            item.setQuantity(0L);
            repository.save(item);
        }
        return items;
    }
}
