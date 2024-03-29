package com.clovischakrian.mykeep.backend.repositories.notes;

import com.clovischakrian.mykeep.backend.models.notes.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
}
