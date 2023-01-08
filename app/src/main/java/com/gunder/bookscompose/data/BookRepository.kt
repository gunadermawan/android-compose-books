package com.gunder.bookscompose.data

import com.gunder.bookscompose.data.model.DummyBooksData
import com.gunder.bookscompose.data.model.BookList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BookRepository {

    private val dataBook = mutableListOf<BookList>()

    init {
        if (dataBook.isEmpty()){
            DummyBooksData.books.forEach {
                dataBook.add(BookList(it, 0))
            }
        }
    }

    fun getAllBook(): Flow<List<BookList>> {
        return flowOf(dataBook)
    }

    fun getPhoneById(phoneId: Long): BookList {
        return dataBook.first {
            it.books.id == phoneId
        }
    }

    companion object {
        @Volatile
        private var instance: BookRepository? = null

        fun getInstance(): BookRepository =
            instance ?: synchronized(this) {
                BookRepository().apply {
                    instance = this
                }
            }
    }
}