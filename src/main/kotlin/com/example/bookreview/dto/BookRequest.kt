package com.example.bookreview.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class BookRequest(
    @field:NotBlank(message = "Title must not be empty")
    @field:Size(max = 255, message = "Title must not exceed 255 characters")
    val title: String,

    @field:NotBlank(message = "Author must not be empty")
    @field:Size(max = 100, message = "Author must not exceed 100 characters")
    val author: String,

    @field:NotBlank(message = "Description must not be empty")
    @field:Size(max = 1000, message = "Description must not exceed 1000 characters")
    val description: String,

    @field:Min(value = 0, message = "Rating must be between 0 and 5")
    @field:Max(value = 5, message = "Rating must be between 0 and 5")
    val rating: Double,

    @field:Min(value = 0, message = "Year must be a positive number")
    val year: Int
)
