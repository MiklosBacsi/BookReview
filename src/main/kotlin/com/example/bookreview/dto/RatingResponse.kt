package com.example.bookreview.dto

data class RatingResponse(
    val id: Long,
    val stars: Int,
    val rating: String,
    val author: String,
    val bookId: Long
)
