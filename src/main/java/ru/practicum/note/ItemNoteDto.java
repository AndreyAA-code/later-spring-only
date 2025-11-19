package ru.practicum.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemNoteDto {
        private Long id;
        private String text;
        private Long itemId;
        private String dateOfNote;
        private String itemUrl;
}
