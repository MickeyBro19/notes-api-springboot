package com.mickey.notesapi.controller;

import com.mickey.notesapi.DTO.NoteRequest;
import com.mickey.notesapi.DTO.NoteResponse;
import com.mickey.notesapi.entity.Note;
import com.mickey.notesapi.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public NoteResponse createNote(
            @Valid @RequestBody NoteRequest request) {

        return noteService.createNote(request);
    }

    @GetMapping
    public Page<NoteResponse> getAllNotes(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {

        return noteService.getAllNotes(page,size,sortBy);
    }

    @GetMapping("/{id}")
    public NoteResponse getNoteById(
            @PathVariable int id) {

        return noteService.getNoteById(id);
    }

    @GetMapping("/search")
    public List<Note> searchNotes(@RequestParam String title){
        return noteService.searchNotes(title);
    }

    @PutMapping("/{id}")
    public NoteResponse updateNote(
            @PathVariable int id,
            @Valid @RequestBody NoteRequest request) {

        return noteService.updateNote(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(
            @PathVariable int id) {

        noteService.deleteNote(id);
    }
}