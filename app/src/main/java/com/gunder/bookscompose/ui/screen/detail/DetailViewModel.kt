package com.gunder.bookscompose.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gunder.bookscompose.data.BookRepository
import com.gunder.bookscompose.data.model.BookList
import com.gunder.bookscompose.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DetailPhoneViewModel(
    private val repository: BookRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<BookList>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<BookList>>
        get() = _uiState

    fun getPhoneById(phoneId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getPhoneById(phoneId))
        }
    }
}