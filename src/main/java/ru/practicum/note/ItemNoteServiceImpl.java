package ru.practicum.note;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly=true)
public class ItemNoteServiceImpl implements ItemNoteService {
    private final ItemNoteRepository itemNoteRepository;

    @Override
    public List<ItemNoteDto> searchNotesByUrl(Long userId, String url) {
        return itemNoteRepository.findAllByItemUrlContainingAndItemUserId(url, userId);
    }
}
