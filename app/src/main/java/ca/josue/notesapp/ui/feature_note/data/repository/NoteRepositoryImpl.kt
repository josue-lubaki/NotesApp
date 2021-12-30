package ca.josue.notesapp.ui.feature_note.data.repository

import ca.josue.notesapp.ui.feature_note.data.data_source.NoteDao
import ca.josue.notesapp.ui.feature_note.domain.model.Note
import ca.josue.notesapp.ui.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao : NoteDao
) : NoteRepository {
    /**
     * Methede qui permet de récupèrer toutes les notes
     * @return array of Note
     * */
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    /**
     * Methode qui permet de récupèrer une Note via son Id
     * @param id identifiant de la note à récupèrer
     * @return Note, sinon null
     * */
    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    /**
     * Methode qui permet d'insérer une Note
     * @param note la note à insérer
     * */
    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    /**
     * Methode qui permet de supprimer une Note
     * @param note la note à supprimer
     * */
    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

}