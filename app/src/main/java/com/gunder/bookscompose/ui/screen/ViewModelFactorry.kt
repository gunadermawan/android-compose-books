package com.gunder.bookscompose.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gunder.bookscompose.data.BookRepository
import com.gunder.bookscompose.ui.screen.detail.DetailPhoneViewModel
import com.gunder.bookscompose.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: BookRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }else if (modelClass.isAssignableFrom(DetailPhoneViewModel::class.java)) {
            return DetailPhoneViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}