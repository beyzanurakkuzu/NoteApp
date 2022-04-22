package com.beyzaakkuzu.noteapp.feature.domain.use_case

import com.beyzaakkuzu.noteapp.feature.domain.model.Note
import com.beyzaakkuzu.noteapp.feature.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note)
    {
        repository.deleteNote(note)
    }
}