package com.vansh.noteapp.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vansh.noteapp.feature_note.presentation.add_edit_notes.AddEditNoteScreen
import com.vansh.noteapp.feature_note.presentation.notes.NotesScreen
import com.vansh.noteapp.feature_note.presentation.util.Screens
import com.vansh.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.NotesScreen)
                    {
                        composable<Screens.NotesScreen> {
                            NotesScreen(
                                navController = navController,
                            )
                        }
                        composable(
                            "addEditNotes/{noteId}/{color}",
                            arguments = listOf(
                                navArgument("noteId") { type = NavType.IntType },
                                navArgument("color") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            val noteId = backStackEntry.arguments?.getInt("noteId") ?: -1
                            val color = backStackEntry.arguments?.getInt("color") ?: -1
                            AddEditNoteScreen(navController,color)
                        }
                    }
                }
            }
        }
    }
}

