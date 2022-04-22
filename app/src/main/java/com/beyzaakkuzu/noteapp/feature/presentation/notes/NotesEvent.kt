package com.beyzaakkuzu.noteapp.feature.presentation.notes

import com.beyzaakkuzu.noteapp.feature.domain.model.Note
import com.beyzaakkuzu.noteapp.feature.domain.util.NoteOrder

sealed class NotesEvent{
    data class Order( val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object RestoreNote: NotesEvent()
    object  ToggleOrderSection: NotesEvent()
}
