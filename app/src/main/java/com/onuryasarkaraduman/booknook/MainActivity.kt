package com.onuryasarkaraduman.booknook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.onuryasarkaraduman.booknook.ui.theme.BookNookTheme
import com.onuryasarkaraduman.navigation.AppNavigation
import com.onuryasarkaraduman.navigation.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookNookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    AppNavigation(
                        navController = navController,
                        startDestination = Route.HomeScreen.route
                    )
                }
            }
        }
    }
}

