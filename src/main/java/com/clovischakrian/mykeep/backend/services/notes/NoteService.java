package com.clovischakrian.mykeep.backend.services.notes;

import com.clovischakrian.mykeep.backend.DTOs.notes.NoteDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteListDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteNewDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteUpdatedDTO;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    public UUID createNote(NoteNewDTO noteNewDTO);
    public List<NoteListDTO> getNotes();
    public UUID updateNote(UUID noteId, NoteUpdatedDTO noteUpdatedDTO);
    public NoteDTO getNote(UUID noteId);
}
