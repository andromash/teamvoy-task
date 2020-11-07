package testtask.teamvoy.service.impl;

import org.junit.jupiter.api.Test;
import testtask.teamvoy.model.Item;

class ItemServiceImplTest {
    private static final Long BANANA_ID = 1L;

    @Test
    void findById() {
        Item banana = new Item();
        banana.setId(BANANA_ID);
        banana.setName("banana");
        banana.setPrice(45L);
        banana.setQuantity(20L);
    }

    @Test
    void save() {
    }

    @Test
    void getAllNeededCheapItem() {
    }
}
