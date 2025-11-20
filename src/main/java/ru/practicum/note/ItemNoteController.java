package ru.practicum.note;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class ItemNoteController {
    private final ItemNoteService itemNoteService;

    @GetMapping("/url")
    public List<ItemNoteDto> get(@RequestHeader("X-Later-User-Id") long userId,
                                 @RequestParam(name = "url") String url) {
        return itemNoteService.searchNotesByUrl(userId, url);
    }

}
