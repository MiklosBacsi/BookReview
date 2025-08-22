package com.example.bookreview.dto

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String,
    val description: String,
    val rating: Double,
    val year: Int
)
