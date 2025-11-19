package ru.practicum.item;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDto> getItems(long userId) {
            return itemRepository.findByUserId(userId);
    }

    public ItemDto addNewItem(Long userId, Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(long userId, long itemId) {
        itemRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}
