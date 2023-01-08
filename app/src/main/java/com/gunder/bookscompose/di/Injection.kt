package com.gunder.bookscompose.di

import com.gunder.bookscompose.data.BookRepository

object Injection {
    fun provideRepository(): BookRepository {
        return BookRepository.getInstance()
    }
}