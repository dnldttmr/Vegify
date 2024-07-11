package de.lovessushi.vegify.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import de.lovessushi.vegify.domain.navigation.NavigationItem

@Composable
fun AppNavigationBar(
    navigationItems: List<NavigationItem>,
    indexChangeListener: ((index: Int, route: String) -> Unit)
) {
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        navigationItems.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                label = { Text(navigationItem.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    indexChangeListener.invoke(index, navigationItem.label)
                },
                icon = { Icon(Icons.Filled.Face, contentDescription = "") }
            )
        }
    }
}