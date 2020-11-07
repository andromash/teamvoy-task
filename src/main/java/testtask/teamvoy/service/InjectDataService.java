package testtask.teamvoy.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testtask.teamvoy.model.Item;

@Component
public class InjectDataService {
    private final ItemService itemService;

    @Autowired
    public InjectDataService(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostConstruct
    public void injectData() {
        Item banana = new Item();
        banana.setName("banana");
        banana.setPrice(45L);
        banana.setQuantity(20L);

        Item apple = new Item();
        apple.setName("apple");
        apple.setPrice(20L);
        apple.setQuantity(50L);

        Item orange = new Item();
        orange.setName("orange");
        orange.setPrice(35L);
        orange.setQuantity(10L);

        itemService.save(banana);
        itemService.save(apple);
        itemService.save(orange);
    }
}
