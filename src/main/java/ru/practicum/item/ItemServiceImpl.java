package ru.practicum.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

   /* public List<ItemDto> getItems(long userId, Set<String> tags) {
       List<ItemDto> itemsDto = itemRepository.findByUserId(userId).
                stream().
                map (ItemMapper::mapToItemDto).
                collect(Collectors.toList());
            return itemsDto;
    } */

    @Override
    public List<ItemDto> getItems(long userId, Set<String> tags) {
        BooleanExpression byUserId = QItem.item.user.id.eq(userId);
        BooleanExpression byAnyTag = QItem.item.tags.any().in(tags);
        Iterable<Item> foundItems = itemRepository.findAll(byUserId.and(byAnyTag));
            return ItemMapper.mapToItemDto(foundItems);
    }

    public ItemDto addNewItem(Long userId, ItemDto itemDto) {
        Item item = ItemMapper.MapToItem(itemDto, user);
        return ItemMapper.mapToItemDto(itemRepository.save(item));
    }

    public void deleteItem(long userId, long itemId) {
        itemRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}
