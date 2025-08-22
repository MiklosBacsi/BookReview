package com.example.bookreview.dto

import com.example.bookreview.model.Rating

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String,
    val description: String,
    val year: Int,
    val rating: Double?
)
