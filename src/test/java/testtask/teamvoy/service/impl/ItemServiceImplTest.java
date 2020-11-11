package testtask.teamvoy.service.impl;

import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import testtask.teamvoy.model.Item;
import testtask.teamvoy.repository.ItemRepository;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

class ItemServiceImplTest {
    private static final Long BANANA_ID = 1L;
    private static final int BANANA_LIST_SIZE = 1;
    private Item banana;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        banana = new Item();
        banana.setId(BANANA_ID);
        banana.setName("banana");
        banana.setPrice(45L);
        banana.setQuantity(20L);
    }

    @Test
    void findById() {
        when(itemRepository.findById(BANANA_ID)).thenReturn(Optional.of(banana));

        Item item = itemService.findById(BANANA_ID);
        Assert.assertEquals(banana, item);
    }

    @Test
    void save() {
        itemService.save(banana);

        verify(itemRepository, times(1)).save(banana);
    }

    @Test
    void getAllNeededCheapItem() {
        when(itemRepository.findByName(banana.getName())).thenReturn(List.of(banana));
        List<Item> allNeededCheapItem = itemService.getAllNeededCheapestItem(banana.getName(), 10L);
        Assert.assertEquals(BANANA_LIST_SIZE, allNeededCheapItem.size());
        verify(itemRepository, times(1)).findByName(banana.getName());
    }
}
