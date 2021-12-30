package ca.josue.notesapp.ui.feature_note.domain.use_cas

import ca.josue.notesapp.ui.feature_note.domain.repository.NoteRepository

data class NoteUseCase(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote
)