package ru.practicum.note;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {

    List<ItemNoteDto> findAllByItemContainingUrlAndItemUserId(String url, Long itemUserId);
}
