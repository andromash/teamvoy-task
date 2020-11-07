package testtask.teamvoy.mappers;

import testtask.teamvoy.dto.ItemRequestDto;
import testtask.teamvoy.model.Item;

public class ItemMapper {

    public Item mapDtoToItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setName(itemRequestDto.getName());
        item.setPrice(itemRequestDto.getPrice());
        item.setQuantity(itemRequestDto.getQuantity());
        return item;
    }
}
