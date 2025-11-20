package ru.practicum.item;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    private ItemService itemService;

    @GetMapping
    public List<ItemDto> get(@RequestHeader("X-Later-User-Id") long userId,
                             @RequestParam(name = "tags", required = false) Set<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return itemService.getItems(userId);
        }
        return itemService.getItems(userId,tags);
    }

    @PostMapping
    public ItemDto add(@RequestHeader("X-Later-User-Id") Long userId,
                    @RequestBody ItemDto itemDto) {
        return itemService.addNewItem(userId, itemDto);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
                           @PathVariable(name="id") long id) {
        itemService.deleteItem(userId, id);
    }
}