package ru.practicum.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import ru.practicum.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {

    public static ItemDto mapToItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setUserId(item.getUser().getId());
        itemDto.setUrl(item.getUrl());
        itemDto.setTags(new HashSet<>(item.getTags()));
        return itemDto;
    }

    public static Item mapToItem(ItemDto itemDto, User user) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setUser(user);
        item.setTags(itemDto.getTags());
        return item;
    }

    public static List<ItemDto> mapToItemDto(Iterable<Item> items) {
        List<ItemDto> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(mapToItemDto(item));
        }
        return dtos;
    }
}
