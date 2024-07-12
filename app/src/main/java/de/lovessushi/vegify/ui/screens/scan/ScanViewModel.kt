package de.lovessushi.vegify.ui.screens.scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.lovessushi.vegify.data.repositories.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ScanState())
    val scanState = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getProduct("9006900014858")
        }
    }

    fun getProduct(code: String) {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(
                    product = productRepository.getProduct(code)
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e)
            }
        }
    }
}