package ru.practicum.item;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDto> getItems(long userId) {
       List<ItemDto> itemsDto= itemRepository.findByUserId(userId).
                stream().
                map (ItemMapper::mapToItemDto).
                collect(Collectors.toList());
            return itemsDto;
    }

    public ItemDto addNewItem(Long userId, ItemDto itemDto) {
        Item item = ItemMapper.MapToItem(itemDto, userId);
        return ItemMapper.mapToItemDto(itemRepository.save(item));
    }

    public void deleteItem(long userId, long itemId) {
        itemRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}
