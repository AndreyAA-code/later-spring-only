package ru.practicum.item;

import java.util.List;
import java.util.Set;

public interface ItemService {

    List<ItemDto> getItems(Long userId, Set<String> tags);

    List<ItemDto> getItems(Long userId);

    ItemDto addNewItem(Long userId, ItemDto itemDto);

    void deleteItem(Long userId, Long itemId);
}
