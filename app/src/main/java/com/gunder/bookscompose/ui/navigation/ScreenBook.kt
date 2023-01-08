package com.gunder.bookscompose.ui.navigation

sealed class ScreenBook(val route: String) {
    object Home : ScreenBook("home")
    object Profile : ScreenBook("profile")
    object DetailBook : ScreenBook("home/{bookId}") {
        fun createRoute(bookId: Long) = "home/$bookId"
    }
}
