package ru.practicum.note;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.item.ItemRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly=true)
public class ItemNoteServiceImpl implements ItemNoteService {
    private final ItemNoteRepository itemNoteRepository;

    @Override
    public ItemNote addNewItemNote(Long userId, ItemNoteDto itemNoteDto) {
        return null;
    }

    @Override
    public List<ItemNoteDto> searchNotesByTag(Long userId, String tag) {
        List<ItemNote> itemNotes = itemNoteRepository.findByTagAndUser(userId, tag);
        return ItemNoteMapper.mapToItemNoteDto(itemNotes);
    }

    @Override
    public List<ItemNoteDto> searchNotesByUrl(Long userId, String url) {
        List<ItemNote> itemNotes = itemNoteRepository.findAllByItemUrlContainingAndItemUserId(url, userId);
        return ItemNoteMapper.mapToItemNoteDto(itemNotes);
    }

    @Override
    public List<ItemNoteDto> listAllItemsWithNotes(Long userId, int from, int size) {
        return List.of();
    }

}
