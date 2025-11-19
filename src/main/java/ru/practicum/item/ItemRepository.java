package ru.practicum.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByUserId(long userId);

    Item save(Item item);

    void deleteByUserIdAndItemId(long userId, long itemId);

    @Query("select new ru.practicum.item.ItemCountByUser(it.user, count(it.id))" +
            "from Item as it where it.itemNote.url like ?1 group by it.user order by count(it.id) desc")
    List<ItemCountByUser> countItemsByUserId(String urlPart);

    @Query(value = "select it.user_id, count(it.id) as count" +
            " from items as it left join users as us on it.user_id = us.id" +
            " where (cast(us.registration_date as date)) between ?1 and ?2 " +
            " group by it.user_id", nativeQuery = true)
    List<ItemCountByUser> countByUserRegistered(LocalDate dateFrom, LocalDate dateTo);

}