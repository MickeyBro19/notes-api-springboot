package com.mickey.notesapi.service;

import com.mickey.notesapi.DTO.NoteRequest;
import com.mickey.notesapi.DTO.NoteResponse;
import com.mickey.notesapi.entity.Note;
import com.mickey.notesapi.exception.ResourceNotFoundException;
import com.mickey.notesapi.repo.NoteRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;

@Service
@NoArgsConstructor
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteResponse createNote(NoteRequest request) {

        Note note = Note.builder()
                .title(request.title())
                .content(request.content())
                .build();

        Note savedNote = noteRepository.save(note);

        return mapToResponse(savedNote);
    }

    @Override
    public Page<NoteResponse> getAllNotes(int page,int size, String sortBy) {
        Pageable pageable= PageRequest.of(page , size, Sort.by(sortBy));
        Page<Note> notes= noteRepository.findAll(pageable);

        return notes
                .map(this::mapToResponse);
    }

    @Override
    public NoteResponse getNoteById(int id) {
        Note note= noteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found with id"+id));

        return mapToResponse(note);

    }

    @Override
    public List<Note> searchNotes(String title) {
        return noteRepository.findByTitleContainingIgnoreCase(title).stream().toList();
    }

    @Override
    public NoteResponse updateNote(int id, NoteRequest request) {
        Note note= noteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found with id"+id));

        note.setTitle(request.title());
        note.setContent(request.content());

        Note updatedNote = noteRepository.save(note);

        return mapToResponse(updatedNote);
    }

    @Override
    public void deleteNote(int id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Note not found with id: " + id));

        noteRepository.delete(note);
    }

    private NoteResponse mapToResponse(Note note){
        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt()
        );
    }
}
