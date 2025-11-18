package ru.practicum.item;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table (name = "item_note")
public class ItemNote {
    @Id
    private Long id;
    private String text;
    private String url;
    private Instant timestamp = Instant.now();

}
