package com.example.bookreview.repository

import com.example.bookreview.model.Rating
import org.springframework.data.jpa.repository.JpaRepository

interface RatingRepository : JpaRepository<Rating, Long> {
    fun findByBookId(bookId: Long): List<Rating>
}