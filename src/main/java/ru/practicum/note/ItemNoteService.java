package ru.practicum.note;

import jakarta.transaction.Transactional;
import java.util.List;

@Transactional
public interface ItemNoteService {

    List<ItemNoteDto> searchNotesByUrl(Long userId, String url);
}
