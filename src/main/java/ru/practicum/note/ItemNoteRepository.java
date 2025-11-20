package ru.practicum.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long>, QuerydslPredicateExecutor<ItemNote> {

    List<ItemNoteDto> findAllByItemUrlContainingAndItemUserId(String url, Long itemUserId);

    @Query
}
