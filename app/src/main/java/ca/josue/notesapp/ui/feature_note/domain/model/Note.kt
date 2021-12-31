package ca.josue.notesapp.ui.feature_note.domain.model

import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.josue.notesapp.ui.theme.*
import java.lang.Exception

@Entity
data class Note (
    val title: String,
    val content : String,
    val timestamp: Long,
    val color : Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGray, Violet, BabyBlue, RedPink, LightGreen)
    }
}

class InvalidNoteException(message : String) : Exception(message)