package org.jd.dataprocessing.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jd.dataprocessing.core.note.NoteService;
import org.jd.domain.dto.NoteDto;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping()
    public List<NoteDto> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("note")
    //@PreAuthorize("hasTenantAccess(#tenantType, #tenantId, 'users:write')")
    public NoteDto addNote(@RequestBody NoteDto noteDto) {

        /** Not enough time to add the security features
         *  This would include a Role based Authentication - Authorization strategy using the PreAuthorize annotations*/
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        var tokenRoles = JwtUtil.extractTokenRoles(auth);
//        var isAdminUser = tokenRoles.stream().anyMatch(TokenRole::isAdminRole);
//        if (noteDto.getCreatedByFullName() == null) {
//            noteDto.setCreatedByFullName(((Jwt)auth.getPrincipal()).getClaim("email"));
//        }
//        if (isAdminUser) {
//            noteDto.setCompany("JD-DEMO");
//        } else {
//            var tokenRole =tokenRoles.stream().findFirst().get();
//            noteDto.setInternalOnly(false);
//        }
        log.info("adding note: {}", noteDto);
        return noteService.addNote(noteDto);
    }

    @PutMapping("/note/{noteId:\\d+}")
    //@PreAuthorize("hasTenantAccess(#tenantType, #tenantId, 'users:write')")
    public NoteDto updateNote(@PathVariable Long noteId, @RequestBody NoteDto noteDto) {
        Assert.isTrue(noteId.equals(noteDto.getId()), "Client id in request must match id in URL");
        log.info("updating note: {}", noteId);
        return noteService.updateNote(noteDto);
    }

    @DeleteMapping("/note/{noteId:\\d+}")
    //@PreAuthorize("hasTenantAccess(#tenantType, #tenantId, 'users:write')")
    public NoteDto deleteNote(@PathVariable Long noteId) {
        log.info("deleting note: {}", noteId);
        return noteService.deleteNote(noteId);
    }
}