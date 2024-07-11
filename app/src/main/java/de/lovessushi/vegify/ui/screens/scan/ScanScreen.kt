package de.lovessushi.vegify.ui.screens.scan

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScanScreen(
    viewModel: ScanViewModel = hiltViewModel()
) {
    Text("Scannen")
}