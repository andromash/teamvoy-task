package testtask.teamvoy.service.impl;

import java.util.NoSuchElementException;
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
}
