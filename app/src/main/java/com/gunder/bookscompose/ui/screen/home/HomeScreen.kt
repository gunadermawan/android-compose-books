package com.gunder.bookscompose.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gunder.bookscompose.data.model.BookList
import com.gunder.bookscompose.di.Injection
import com.gunder.bookscompose.ui.components.BookItem
import com.gunder.bookscompose.ui.screen.ViewModelFactory
import com.gunder.bookscompose.ui.state.UiState


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllBook()
            }
            is UiState.Success -> {
                HomeContent(
                    bookLists = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {
            }
        }
    }
}

@Composable
fun HomeContent(
    bookLists: List<BookList>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(bookLists) { data ->
            BookItem(
                image = data.books.photoUrl,
                year = data.books.year,
                title = data.books.name,
                modifier = Modifier.clickable {
                    navigateToDetail(data.books.id)
                }
            )
        }
    }
}