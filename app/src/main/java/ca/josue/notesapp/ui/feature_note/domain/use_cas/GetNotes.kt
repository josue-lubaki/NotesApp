package ca.josue.notesapp.ui.feature_note.domain.use_cas

import ca.josue.notesapp.ui.feature_note.domain.model.Note
import ca.josue.notesapp.ui.feature_note.domain.repository.NoteRepository
import ca.josue.notesapp.ui.feature_note.domain.util.NoteOrder
import ca.josue.notesapp.ui.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow

class GetNotes(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes()
    }
}

//
//.map { notes ->
//    when(noteOrder.orderType){
//        is OrderType.Ascending -> {
//            when(noteOrder) {
//                is NoteOrder.Title -> notes.sortedBy { it.title.toLowerCase() }.toList()
//                is NoteOrder.Date -> notes.sortedBy { it.timestamp }.toList()
//                is NoteOrder.Color -> notes.sortedBy { it.color }.toList()
//            }
//        }
//        is OrderType.Descending -> {
//            when(noteOrder) {
//                is NoteOrder.Title -> notes.sortedByDescending { it.title.toLowerCase() }.toList()
//                is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }.toList()
//                is NoteOrder.Color -> notes.sortedByDescending { it.color }.toList()
//            }
//        }
//    }
//}