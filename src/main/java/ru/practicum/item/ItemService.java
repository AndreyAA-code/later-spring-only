package ru.practicum.item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getItems(long userId) {
            return null;
    }


    public Item addNewItem(Long userId, Item item) {
        return null;
    }

    public void deleteItem(long userId, long itemId) {
    }
}
