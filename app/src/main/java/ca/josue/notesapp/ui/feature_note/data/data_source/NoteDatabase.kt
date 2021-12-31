package ca.josue.notesapp.ui.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import ca.josue.notesapp.ui.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    //abstract val noteDao : NoteDao
    abstract fun noteDao() : NoteDao

    companion object{
        const val DATABASE_NAME = "notes_db"
    }
}