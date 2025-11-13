package ru.practicum.item;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ItemDto {
    private Long id;
    private Long userId;
    private String url;
    private Set<String> tags = new HashSet<>();

}
