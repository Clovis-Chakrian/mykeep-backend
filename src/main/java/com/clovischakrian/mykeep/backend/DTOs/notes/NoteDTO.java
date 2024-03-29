package com.clovischakrian.mykeep.backend.DTOs.notes;

import com.clovischakrian.mykeep.backend.models.notes.Note;

import java.util.Date;
import java.util.UUID;

public record NoteDTO(UUID id, String title, String description, Date createdAt, Date updatedAt) {
    public NoteDTO(Note note) {
        this(note.getId(), note.getTitle(), note.getDescription(), note.getCreatedAt(), note.getUpdatedAt());
    }
}
