package ca.josue.notesapp.feature_note.presentation.notes

import ca.josue.notesapp.feature_note.domain.model.Note
import ca.josue.notesapp.feature_note.domain.util.NoteOrder
import ca.josue.notesapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
