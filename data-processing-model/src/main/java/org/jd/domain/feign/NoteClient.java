package org.jd.domain.feign;

import org.jd.domain.dto.NoteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "note", url = "${data-processing.url}/notes")
public interface NoteClient {

    @PostMapping("note")
    NoteDto addNote(@RequestBody NoteDto noteDto);

    @PutMapping("/note/{noteId:\\d+}")
    NoteDto updateNote(@PathVariable Long noteId, @RequestBody NoteDto noteDto);

    @DeleteMapping("/note/{noteId:\\d+}")
    NoteDto deleteNote(@PathVariable Long noteId);

    @GetMapping()
    List<NoteDto> getAllNotes();
}
