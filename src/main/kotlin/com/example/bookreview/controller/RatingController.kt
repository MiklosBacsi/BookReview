package com.example.bookreview.controller

import com.example.bookreview.dto.RatingRequest
import com.example.bookreview.dto.RatingResponse
import com.example.bookreview.service.RatingService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class RatingController(private val ratingService: RatingService) {

    @GetMapping("/ratings")
    fun getAllRatings(): List<RatingResponse> {
        return ratingService.getAllRatings()
    }

    @GetMapping("/book/{bookId}/ratings")
    fun getRatingsByBookId(@PathVariable bookId: Long): List<RatingResponse> {
        return ratingService.getRatingsByBookId(bookId)
    }


    @PostMapping("/rating")
    fun createRating(@Valid @RequestBody ratingRequest: RatingRequest): RatingResponse {
        val createdRating = ratingService.createRating(ratingRequest)
        return createdRating
    }
}