package com.gunder.bookscompose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gunder.bookscompose.data.BookRepository
import com.gunder.bookscompose.data.model.BookList
import com.gunder.bookscompose.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: BookRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<BookList>>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<List<BookList>>>
        get() = _uiState

    fun getAllBook() {
        viewModelScope.launch {
            repository.getAllBook()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { dataPhone ->
                    _uiState.value = UiState.Success(dataPhone)
                }
        }
    }
}