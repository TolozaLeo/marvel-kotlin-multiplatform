package dev.leotoloza.marvelkmmapp.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.leotoloza.marvelkmmapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharacterRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val uiState: StateFlow<CharactersUiState> = _uiState.asStateFlow()

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            _uiState.value = CharactersUiState.Loading
            runCatching {
                repository.getCharacters()
            }.onSuccess { list ->
                _uiState.value = CharactersUiState.Success(list)
            }.onFailure { err ->
                _uiState.value = CharactersUiState.Error(
                    err.localizedMessage ?: "Error desconocido ${err.message}"
                )
            }
        }
    }
}