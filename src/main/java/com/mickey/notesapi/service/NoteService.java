package com.mickey.notesapi.service;

import com.mickey.notesapi.DTO.NoteRequest;
import com.mickey.notesapi.DTO.NoteResponse;
import com.mickey.notesapi.entity.Note;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NoteService {

    NoteResponse createNote(NoteRequest request);
    Page<NoteResponse> getAllNotes (int page, int size, String sortBy);
    NoteResponse getNoteById(int id);
    List<Note> searchNotes(String title);
    NoteResponse updateNote(int id, NoteRequest request);
    void deleteNote(int id);


}
