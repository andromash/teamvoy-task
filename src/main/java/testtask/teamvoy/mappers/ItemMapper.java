package testtask.teamvoy.mappers;

import com.test.task.dto.ItemRequestDto;
import com.test.task.model.Item;

public class ItemMapper {

    public Item mapDtoToItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setName(itemRequestDto.getName());
        item.setPrice(itemRequestDto.getPrice());
        item.setQuantity(itemRequestDto.getQuantity());
        return item;
    }
}
