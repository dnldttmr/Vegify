package de.lovessushi.vegify.ui.screens.discover

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.lovessushi.vegify.data.repositories.ProductRepository
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val sampleRepository: ProductRepository
) : ViewModel() {

}