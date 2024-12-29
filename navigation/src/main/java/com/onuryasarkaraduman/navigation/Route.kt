package com.onuryasarkaraduman.navigation

sealed class Route(val route: String) {

    data object HomeScreen : Route(route = "homeScreen")
    data object SearchScreen : Route(route = "searchScreen")
    data object FavoritesScreen : Route(route = "favoritesScreen")
}