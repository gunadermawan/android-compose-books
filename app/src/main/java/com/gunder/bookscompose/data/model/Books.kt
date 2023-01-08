package com.gunder.bookscompose.data.model

data class Books(
    val id: Long,
    val name: String,
    val brand: String,
    val photoUrl: Int,
    val price: String,
    val description: String,
    val releaseDate: String,
    val year: String
)