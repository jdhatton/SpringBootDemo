package org.jd.dataprocessing.core.note;

import lombok.RequiredArgsConstructor;
import org.jd.domain.dto.NoteDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteMapper noteMapper;
    private final NoteRepository noteRepository;

    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return noteMapper.toDtoList(notes);
    }

    @Transactional
    public NoteDto addNote(NoteDto noteDto) {

        Note savedNote = noteMapper.fromDto(noteDto);
        noteRepository.save(savedNote);
        return noteMapper.toDto(savedNote);
    }

    @Transactional
    public NoteDto updateNote(NoteDto noteDto) {
        Note updatedNote = noteMapper.fromDto(noteDto);
        noteRepository.save(updatedNote);
        return noteMapper.toDto(updatedNote);
    }

    @Transactional
    public NoteDto deleteNote(Long noteId) {
        Optional<Note> deletedNote = noteRepository.findById(noteId);
        noteRepository.delete(deletedNote.get());
        return noteMapper.toDto(deletedNote.get());
    }
}
