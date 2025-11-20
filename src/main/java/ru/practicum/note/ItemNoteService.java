package ru.practicum.note;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ItemNoteService {

    ItemNoteDto addNewItemNote(Long userId, ItemNoteDto itemNoteDto);

    List<ItemNoteDto> searchNotesByUrl(Long userId, String url);

    List<ItemNoteDto> searchNotesByTag(Long userId, String tag);

    List<ItemNoteDto> listAllItemsWithNotes(Long userId, int from, int size);

}
