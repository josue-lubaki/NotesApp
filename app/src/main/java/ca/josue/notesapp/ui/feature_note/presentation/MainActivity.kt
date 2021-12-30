package ca.josue.notesapp.ui.feature_note.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import ca.josue.notesapp.R
import ca.josue.notesapp.ui.theme.notesAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent{
            notesAppTheme {

            }
        }
    }
}