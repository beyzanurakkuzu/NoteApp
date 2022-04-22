package com.beyzaakkuzu.noteapp.feature.domain.use_case

import com.beyzaakkuzu.noteapp.feature.domain.model.InvalidNoteException
import com.beyzaakkuzu.noteapp.feature.domain.model.Note
import com.beyzaakkuzu.noteapp.feature.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}