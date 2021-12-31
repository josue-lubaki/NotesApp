package ca.josue.notesapp.ui.di

import android.app.Application
import androidx.room.Room
import ca.josue.notesapp.ui.feature_note.data.data_source.NoteDatabase
import ca.josue.notesapp.ui.feature_note.data.repository.NoteRepositoryImpl
import ca.josue.notesapp.ui.feature_note.domain.repository.NoteRepository
import ca.josue.notesapp.ui.feature_note.domain.use_cas.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app : Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase) : NoteRepository {
        return NoteRepositoryImpl(db.noteDao())
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository : NoteRepository) : NoteUseCase {
        return NoteUseCase(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }

}