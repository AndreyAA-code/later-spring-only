package ru.practicum.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {

    public static ItemDto from(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setUserId(item.getUserId());
        itemDto.setUrl(item.getUrl());
        itemDto.setTags(item.getTags());
        return itemDto;
    }

    public static Item from(ItemDto itemDto, Long userId) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setUserId(userId);
        item.setUrl(itemDto.getUrl());
        item.setTags(itemDto.getTags());
        return item;
    }
}
