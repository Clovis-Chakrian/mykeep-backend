package com.clovischakrian.mykeep.backend.models.notes;

import com.clovischakrian.mykeep.backend.DTOs.notes.NoteNewDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteUpdatedDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "notes")
@Entity(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Note {
    @Id
    private UUID id;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    public Note(NoteNewDTO noteNewDTO) {
        this.title = noteNewDTO.title();
        this.description = noteNewDTO.description();
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public void update(NoteUpdatedDTO noteUpdatedDTO) {
        this.setTitle(noteUpdatedDTO.title());
        this.setDescription(noteUpdatedDTO.description());
        this.setUpdatedAt(new Date());
    }
}
