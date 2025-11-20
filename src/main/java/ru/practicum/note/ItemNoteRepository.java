package ru.practicum.note;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long>, QuerydslPredicateExecutor<ItemNote> {

    List<ItemNote> findAllByItemUrlContainingAndItemUserId(String url, Long itemUserId);

    @Query ("SELECT itNote FROM ItemNote as itNote JOIN itNote.item as i WHERE i.user.id =?1 and ?2 member of i.tags ")
    List<ItemNote> findByTagAndUser(Long userId, String tag);

    Page<ItemNote> findAllByItemUserId(Long itemUserId, Pageable pageRequest);

}
