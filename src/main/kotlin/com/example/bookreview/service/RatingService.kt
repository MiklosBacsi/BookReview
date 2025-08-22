package com.example.bookreview.service

import com.example.bookreview.dto.BookResponse
import com.example.bookreview.dto.RatingRequest
import com.example.bookreview.dto.RatingResponse
import com.example.bookreview.model.Book
import com.example.bookreview.model.Rating
import com.example.bookreview.repository.BookRepository
import com.example.bookreview.repository.RatingRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RatingService(
    private val ratingRepository: RatingRepository,
    private val bookRepository: BookRepository
) {
    fun getAllRatings(): List<RatingResponse> {
        return ratingRepository.findAll().map { it.toResponse() }
    }

    fun getRatingsByBookId(bookId: Long): List<RatingResponse> {
        return ratingRepository.findByBookId(bookId).map { it.toResponse() }
    }

    @Transactional
    fun createRating(ratingRequest: RatingRequest): RatingResponse {
        val book = bookRepository.findByIdOrNull(ratingRequest.bookId)
            ?: throw IllegalArgumentException("Book with ID ${ratingRequest.bookId} not found")
        val rating = Rating(
            stars = ratingRequest.stars,
            rating = ratingRequest.rating,
            author = ratingRequest.author,
            book = book
        )
        return ratingRepository.save(rating).toResponse()
    }

    private fun Rating.toResponse() = RatingResponse(
        id = id,
        stars = stars,
        rating = rating,
        author = author,
        bookId = book.id
    )
}