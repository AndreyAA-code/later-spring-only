package ru.practicum.note;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.practicum.item.Item;
import java.time.Instant;

    @Getter
    @Setter
    @ToString
    @Entity
    @Table(name = "item_note")
    public class ItemNote {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String text;

        @ManyToOne(fetch = FetchType.LAZY)
        @ToString.Exclude
        private Item item;

        @Column(name = "date")
        private Instant dateOfNote = Instant.now();

    }
