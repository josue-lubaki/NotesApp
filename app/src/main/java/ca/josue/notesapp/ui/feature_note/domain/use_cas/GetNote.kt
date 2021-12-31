package ca.josue.notesapp.ui.feature_note.domain.use_cas

import ca.josue.notesapp.ui.feature_note.domain.model.Note
import ca.josue.notesapp.ui.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id : Int) : Note? {
        return repository.getNoteById(id)
    }
}