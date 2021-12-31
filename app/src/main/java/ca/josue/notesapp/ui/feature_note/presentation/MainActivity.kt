package ca.josue.notesapp.ui.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ca.josue.notesapp.ui.feature_note.presentation.add_edit_note.AddEditNoteScreen
import ca.josue.notesapp.ui.feature_note.presentation.notes.components.NotesScreen
import ca.josue.notesapp.ui.feature_note.presentation.util.Screen
import ca.josue.notesapp.ui.theme.notesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            notesAppTheme(darkTheme = true) {
                Surface(
                    color = MaterialTheme.colors.background
                ){
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ){
                        composable(route = Screen.NotesScreen.route){
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route
                                    + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ){
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(
        color = Color.Yellow,
    ){
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(4.dp)
        )
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    notesAppTheme(true) {
        Surface(
            color = MaterialTheme.colors.background
        ){
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.NotesScreen.route
            ){
                composable(route = Screen.NotesScreen.route){
                    NotesScreen(navController = navController)
                }
                composable(
                    route = Screen.AddEditNoteScreen.route
                            + "?noteId={noteId}&noteColor={noteColor}",
                    arguments = listOf(
                        navArgument(
                            name = "noteId"
                        ){
                            type = NavType.IntType
                            defaultValue = -1
                        },
                        navArgument(
                            name = "noteColor"
                        ){
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    )
                ){
                    val color = it.arguments?.getInt("noteColor") ?: -1
                    AddEditNoteScreen(
                        navController = navController,
                        noteColor = color
                    )
                }
            }
        }
    }
}



//package ca.josue.notesapp.ui.feature_note.presentation
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.activity.compose.setContent
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.navArgument
//import androidx.navigation.compose.rememberNavController
//import ca.josue.notesapp.R
//import ca.josue.notesapp.ui.feature_note.presentation.add_edit_note.AddEditNoteScreen
//import ca.josue.notesapp.ui.feature_note.presentation.notes.components.NotesScreen
//import ca.josue.notesapp.ui.feature_note.presentation.util.Screen
//import ca.josue.notesapp.ui.theme.notesAppTheme
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//    @ExperimentalAnimationApi
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setContent{
//            notesAppTheme(darkTheme = true) {
//                Surface(
//                    color = MaterialTheme.colors.background
//                ){
//                    val navController = rememberNavController()
//                    NavHost(
//                        navController = navController,
//                        startDestination = Screen.NotesScreen.route
//                    ){
//                        composable(route = Screen.NotesScreen.route){
//                            NotesScreen(navController = navController)
//                        }
//                        composable(
//                            route = Screen.AddEditNoteScreen.route
//                                    + "?noteId={noteId}&noteColor={noteColor}",
//                        arguments = listOf(
//                                navArgument(
//                                    name = "noteId"
//                                ){
//                                    type = NavType.IntType
//                                    defaultValue = -1
//                                },
//                                navArgument(
//                                    name = "noteColor"
//                                ){
//                                    type = NavType.IntType
//                                    defaultValue = -1
//                                }
//                            )
//                        ){
//                            val color = it.arguments?.getInt("noteColor") ?: -1
//                            AddEditNoteScreen(
//                                navController = navController,
//                                noteColor = color
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}