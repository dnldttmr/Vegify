package de.lovessushi.vegify.ui.screens.discover

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.lovessushi.vegify.data.repositories.SampleRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {

}