package com.onuryasarkaraduman.booknook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.onuryasarkaraduman.booknook.ui.theme.BookNookTheme
import com.onuryasarkaraduman.navigation.AppNavigation
import com.onuryasarkaraduman.navigation.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookNookTheme {
                    val navController = rememberNavController()
                    AppNavigation(
                        navController = navController,
                        startDestination = Route.WelcomeScreen.route
                    )
            }
        }
    }
}

