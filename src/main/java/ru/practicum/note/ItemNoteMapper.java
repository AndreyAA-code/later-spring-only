package ru.practicum.note;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.item.Item;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemNoteMapper {
    public static ItemNoteDto mapToItemNoteDto(ItemNote itemNote) {
        String dateOfNote = DateTimeFormatter
                .ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(itemNote.getDateOfNote());

        return new ItemNoteDto(
                itemNote.getId(),
                itemNote.getText(),
                itemNote.getItem().getId(),
                dateOfNote,
                itemNote.getItem().getUrl()
        );
    }
    public static ItemNote mapToItemNote(ItemNoteDto itemNoteDto, Item item) {
            ItemNote itemNote = new ItemNote();
            itemNote.setItem(item);
            itemNote.setText(itemNoteDto.getText());
            return itemNote;
    }

    public static List<ItemNoteDto> mapToItemNoteDto(List<ItemNote> itemNotes) {
        List<ItemNoteDto> itemNoteDtos = new ArrayList<>();
        for (ItemNote itemNote : itemNotes) {
        }
        return itemNoteDtos;
    }

}
