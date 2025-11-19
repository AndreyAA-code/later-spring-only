package ru.practicum.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import ru.practicum.user.User;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemMapper {

    public static ItemDto mapToItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setUserId(item.getUser().getId());
        itemDto.setUrl(item.getItemNote().getUrl());
        itemDto.setTags(item.getTags());
        return itemDto;
    }

    public static Item MapToItem(ItemDto itemDto, User user) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setUser(user);
      // item.setItemNote(ItemNote itemnote);
        item.setTags(itemDto.getTags());
        return item;
    }
}
