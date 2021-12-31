package ca.josue.notesapp.ui.feature_note.domain.use_cas

data class NoteUseCase(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote
)