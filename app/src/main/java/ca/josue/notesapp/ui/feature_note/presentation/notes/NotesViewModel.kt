package ca.josue.notesapp.ui.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.josue.notesapp.ui.feature_note.domain.model.Note
import ca.josue.notesapp.ui.feature_note.domain.use_cas.NoteUseCase
import ca.josue.notesapp.ui.feature_note.domain.util.NoteOrder
import ca.josue.notesapp.ui.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCase
    ) : ViewModel() {

    private val _state = MutableStateFlow(NotesState())
    val state : StateFlow<NotesState> = _state

    private var recentlyDeletedNote : Note? = null
    private var getNotesJob : Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

        fun onEvent(event : NotesEvent){
            when(event){
                is NotesEvent.Order -> {
                    if(state.value.noteOrder::class == event.noteOrder::class &&
                            state.value.noteOrder.orderType == event.noteOrder.orderType
                    ){
                        return
                    }
                    getNotes(event.noteOrder)
                }
                is NotesEvent.DeleteNote -> {
                    viewModelScope.launch {
                        noteUseCases.deleteNote(event.note)
                        recentlyDeletedNote = event.note
                    }
                }
                is NotesEvent.RestoreNote -> {
                    viewModelScope.launch{
                        noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                        recentlyDeletedNote = null
                    }
                }
                is NotesEvent.ToggleOrderSection -> {
                    _state.value = state.value.copy(
                        isOrderSectionVisible = !state.value.isOrderSectionVisible
                    )
                }
            }
        }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(noteOrder).onEach {
            notes -> _state.value = state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}