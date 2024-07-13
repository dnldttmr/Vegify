package de.lovessushi.vegify.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.lovessushi.vegify.data.repositories.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SearchScreenState())
    val searchScreenState = _state.asStateFlow()

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