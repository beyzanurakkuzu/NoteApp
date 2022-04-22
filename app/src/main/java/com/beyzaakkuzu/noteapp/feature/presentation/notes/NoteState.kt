package com.beyzaakkuzu.noteapp.feature.presentation.notes

import com.beyzaakkuzu.noteapp.feature.domain.model.Note
import com.beyzaakkuzu.noteapp.feature.domain.util.NoteOrder
import com.beyzaakkuzu.noteapp.feature.domain.util.OrderType


data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder= NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean= false
)
