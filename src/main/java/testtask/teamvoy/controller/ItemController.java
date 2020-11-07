package testtask.teamvoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testtask.teamvoy.dto.ItemResponseDto;
import testtask.teamvoy.mappers.ItemMapper;
import testtask.teamvoy.model.Item;
import testtask.teamvoy.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemMapper itemMapper, ItemService itemService) {
        this.itemMapper = itemMapper;
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemResponseDto> buyItem(@RequestParam String name, @RequestParam Long quantity) {
        return itemService.getAllNeededCheapItem(name, quantity).stream()
                .map(itemMapper::mapItemTODto)
                .collect(Collectors.toList());
    }
}
