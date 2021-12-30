package ca.josue.notesapp.ui.feature_note.domain.repository

import ca.josue.notesapp.ui.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    /**
     * Methede qui permet de récupèrer toutes les notes
     * @return array of Note
     * */
    fun getNotes() : Flow<List<Note>>

    /**
     * Methode qui permet de récupèrer une Note via son Id
     * @param id identifiant de la note à récupèrer
     * @return Note, sinon null
     * */
    suspend fun getNoteById(id: Int) : Note?

    /**
     * Methode qui permet d'insérer une Note
     * @param note la note à insérer
     * */
    suspend fun insertNote(note : Note)

    /**
     * Methode qui permet de supprimer une Note
     * @param note la note à supprimer
     * */
    suspend fun deleteNote(note: Note)
}