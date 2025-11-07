package ru.practicum.item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.practicum.user.User;

import java.util.List;

@Repository
@Slf4j
public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public List<Item> findByUserId(long userId) {
        return List.of();
    }

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {

    }
}
