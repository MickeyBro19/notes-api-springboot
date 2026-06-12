package com.mickey.notesapi.repo;

import com.mickey.notesapi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByTitleContainingIgnoreCase(String title);
}
