package testtask.teamvoy.mappers;

import org.springframework.stereotype.Component;
import testtask.teamvoy.dto.ItemRequestDto;
import testtask.teamvoy.dto.ItemResponseDto;
import testtask.teamvoy.model.Item;

@Component
public class ItemMapper {

    public Item mapDtoToItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setName(itemRequestDto.getName());
        item.setPrice(itemRequestDto.getPrice());
        item.setQuantity(itemRequestDto.getQuantity());
        return item;
    }

    public ItemResponseDto mapItemTODto(Item item) {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setId(item.getId());
        itemResponseDto.setName(item.getName());
        itemResponseDto.setPrice(item.getPrice());
        itemResponseDto.setQuantity(item.getQuantity());
        return itemResponseDto;
    }
}
