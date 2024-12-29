package com.onuryasarkaraduman.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.onuryasarkaraduman.core.R
import com.onuryasarkaraduman.navigation.components.BookNookBottomNavigation
import com.onuryasarkaraduman.navigation.components.BottomNavigationItem
import com.onuryasarkaraduman.presentation.FavoritesScreen
import com.onuryasarkaraduman.presentation.HomeScreen
import com.onuryasarkaraduman.presentation.SearchScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String,
) {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_favorite_fill, text = "Favorites"),
        )
    }


    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.FavoritesScreen.route -> 2
        else -> 0
    }


    //Hide the bottom navigation when the user is in the other screens
    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.SearchScreen.route ||
                backStackState?.destination?.route == Route.FavoritesScreen.route
    }


    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if (isBottomBarVisible) {
            BookNookBottomNavigation(
                item = bottomNavigationItems,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )

                        2 -> navigateToTab(
                            navController = navController,
                            route = Route.FavoritesScreen.route
                        )
                    }
                }
            )
        }

    }) {
        val bottomPadding = it.calculateBottomPadding()

        NavHost(
            modifier = Modifier.padding(bottom = bottomPadding),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(route = Route.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Route.SearchScreen.route) {
                SearchScreen()
            }
            composable(route = Route.FavoritesScreen.route) {
                FavoritesScreen()
            }

        }


    }

}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}