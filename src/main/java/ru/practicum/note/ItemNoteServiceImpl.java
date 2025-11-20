package ru.practicum.note;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.item.Item;
import ru.practicum.item.ItemRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly=true)
public class ItemNoteServiceImpl implements ItemNoteService {
    private final ItemNoteRepository itemNoteRepository;
    private final ItemRepository itemRepository;

    @Override
    public ItemNoteDto addNewItemNote(Long userId, ItemNoteDto itemNoteDto) {
        Item item = itemRepository.findById(itemNoteDto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        ItemNote itemNote = itemNoteRepository.save(ItemNoteMapper.mapToItemNote(itemNoteDto, item));
        return ItemNoteMapper.mapToItemNoteDto(itemNote);
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
        PageRequest pageRequest = PageRequest.of(from, size);
        return itemNoteRepository.findAllByItemUserId(userId, pageRequest)
                .map(ItemNoteMapper::mapToItemNoteDto)
                .getContent();
    }

}
