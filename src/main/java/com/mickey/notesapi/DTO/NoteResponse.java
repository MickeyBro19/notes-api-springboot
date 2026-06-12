package com.mickey.notesapi.DTO;

import java.time.LocalDateTime;

public record NoteResponse(
        int id,
        String title,
        String content,
        LocalDateTime createdAt
) {



}
