package ru.practicum.note;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class ItemNoteController {
    private final ItemNoteService itemNoteService;

    @GetMapping(params = "url")
    public List<ItemNoteDto> searchNotesByUrl(@RequestHeader("X-Later-User-Id") long userId,
                                 @RequestParam(name = "url") String url) {
        return itemNoteService.searchNotesByUrl(userId, url);
    }

    @GetMapping(params = "tag")
    public List<ItemNoteDto> searchNotesByTag(@RequestHeader("X-Later-User-Id") long userId,
                                 @RequestParam(name = "tag") String tag) {
        return itemNoteService.searchNotesByTag(userId, tag);
    }

    @GetMapping
    public List<ItemNoteDto> listAllNotes(@RequestHeader("X-Later-User-Id") long userId,
                                          @RequestParam(name = "from", defaultValue = "0") int from,
                                          @RequestParam(name= "size", defaultValue = "10") int size) {
        return itemNoteService.listAllItemsWithNotes(userId, from, size);
    }

    @PostMapping
    public ItemNoteDto addNote(@RequestHeader("X-Later-User-Id") Long userId,
                               @RequestBody ItemNoteDto itemNoteDto) {
        return itemNoteService.addNewItemNote(userId, itemNoteDto);
    }

}
