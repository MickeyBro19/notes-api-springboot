package com.mickey.notesapi.DTO;

import jakarta.validation.constraints.NotBlank;

public record NoteRequest (

    @NotBlank(message = "Title can't be empty")
    String title,

    @NotBlank(message = "Content can't be empty")
    String content
)
{
}
