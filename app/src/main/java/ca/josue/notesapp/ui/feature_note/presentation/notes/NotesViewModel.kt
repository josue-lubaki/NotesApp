package ca.josue.notesapp.ui.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.josue.notesapp.ui.feature_note.domain.model.Note
import ca.josue.notesapp.ui.feature_note.domain.use_cas.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCase
    ) : ViewModel() {

//    private val _state = mutableListOf(NotesState())
//    val state : State<NotesState> = _state

    private var recentlyDeletedNote : Note? = null

        fun onEvent(event : NotesEvent){
            when(event){
                is NotesEvent.Order -> {

                }
                is NotesEvent.DeleteNote -> {
                    viewModelScope.launch {
                        noteUseCases.deleteNote(event.note)
                        recentlyDeletedNote = event.note
                    }
                }
                is NotesEvent.RestoreNote -> {
                    viewModelScope.launch{

                    }
                }
                is NotesEvent.ToggleOrderSection -> {
//                    _state.value = state.value.copy(
//                        isOrderSectionVisible = !state.value.isOrderSectionVisible
//                    )
                }
            }
        }
}