package com.clovischakrian.mykeep.backend.services.notes;

import com.clovischakrian.mykeep.backend.DTOs.notes.NoteDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteListDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteNewDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteUpdatedDTO;
import com.clovischakrian.mykeep.backend.models.notes.Note;
import com.clovischakrian.mykeep.backend.repositories.notes.NoteRepository;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteServiceImplementation implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImplementation(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public UUID createNote(NoteNewDTO noteNewDTO) {
        Note note = new Note(noteNewDTO);
        note.setId(UUID.randomUUID());
        noteRepository.save(note);

        return note.getId();
    }

    @Override
    public List<NoteListDTO> getNotes() {
        List<NoteListDTO> notesList = noteRepository.findAll().stream().map(NoteListDTO::new).toList();

        return notesList;
    }

    @Override
    public UUID updateNote(UUID noteId, NoteUpdatedDTO noteUpdatedDTO) {
        Note note = noteRepository.getReferenceById(noteId);

        note.update(noteUpdatedDTO);

        noteRepository.save(note);

        return note.getId();
    }

    @Override
    public NoteDTO getNote(UUID noteId) {
        Note note = noteRepository.getReferenceById(noteId);

        return new NoteDTO(note);
    }
}
