package com.clovischakrian.mykeep.backend.controllers;

import com.clovischakrian.mykeep.backend.DTOs.notes.NoteDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteListDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteNewDTO;
import com.clovischakrian.mykeep.backend.DTOs.notes.NoteUpdatedDTO;
import com.clovischakrian.mykeep.backend.services.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public UUID post(@RequestBody NoteNewDTO noteNewDTO) {
        return noteService.createNote(noteNewDTO);
    }

    @PutMapping("/{noteId}")
    public UUID update(@PathVariable UUID noteId, @RequestBody NoteUpdatedDTO noteUpdatedDTO) {
        return noteService.updateNote(noteId, noteUpdatedDTO);
    }

    @GetMapping()
    public List<NoteListDTO> getAll() {
        return noteService.getNotes();
    }

    @GetMapping("/{noteId}")
    public NoteDTO get(@PathVariable UUID noteId) {
        return noteService.getNote(noteId);
    }
}
