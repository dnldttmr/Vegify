package de.lovessushi.vegify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import de.lovessushi.vegify.domain.navigation.NavigationItem.HISTORY
import de.lovessushi.vegify.domain.navigation.NavigationItem.HOME
import de.lovessushi.vegify.domain.navigation.NavigationItem.SCAN
import de.lovessushi.vegify.ui.composables.AppNavigationBar
import de.lovessushi.vegify.ui.screens.discover.DiscoverScreen
import de.lovessushi.vegify.ui.screens.history.HistoryScreen
import de.lovessushi.vegify.ui.screens.scan.ScanScreen
import de.lovessushi.vegify.ui.theme.VegifyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VegifyTheme {
                val navController = rememberNavController()

                Scaffold(bottomBar = {
                    AppNavigationBar(
                        navigationItems = listOf(HOME, SCAN, HISTORY),
                        indexChangeListener = { index, route ->
                            navController.navigate(route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }) { paddingValues ->
                    NavHost(
                        modifier = Modifier.padding(paddingValues),
                        navController = navController,
                        startDestination = SCAN.label
                    ) {
                        composable(HOME.label) { DiscoverScreen() }
                        composable(SCAN.label) { ScanScreen() }
                        composable(HISTORY.label) { HistoryScreen() }
                    }
                }
            }
        }
    }
}