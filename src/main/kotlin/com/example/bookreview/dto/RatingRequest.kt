package com.example.bookreview.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RatingRequest(
    @field:Min(value = 1, message = "Stars must be at least 1")
    @field:Max(value = 5, message = "Stars must not exceed 5")
    val stars: Int,

    @field:NotBlank(message = "Rating description must not be empty")
    @field:Size(max = 1000, message = "Rating description must not exceed 1000 characters")
    val rating: String,

    @field:NotBlank(message = "Author must not be empty")
    @field:Size(max = 100, message = "Author must not exceed 100 characters")
    val author: String,

    val bookId: Long
)
