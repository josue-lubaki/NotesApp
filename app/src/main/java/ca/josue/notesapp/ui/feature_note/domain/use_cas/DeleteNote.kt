package ca.josue.notesapp.ui.feature_note.domain.use_cas

import ca.josue.notesapp.ui.feature_note.domain.model.Note
import ca.josue.notesapp.ui.feature_note.domain.repository.NoteRepository

class DeleteNote (
    private val repository: NoteRepository
        ) {

    suspend operator fun invoke (note : Note){
        repository.deleteNote(note)
    }
}