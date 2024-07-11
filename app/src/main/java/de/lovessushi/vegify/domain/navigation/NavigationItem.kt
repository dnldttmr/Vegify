package de.lovessushi.vegify.domain.navigation

sealed class NavigationItem(
    val label: String
) {

    data object HOME : NavigationItem(label = "Home")
    data object SCAN : NavigationItem(label = "Scan")
    data object HISTORY : NavigationItem(label = "History")
}