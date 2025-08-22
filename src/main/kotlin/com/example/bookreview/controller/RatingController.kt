package com.example.bookreview.controller

import com.example.bookreview.dto.BookResponse
import com.example.bookreview.dto.RatingRequest
import com.example.bookreview.dto.RatingResponse
import com.example.bookreview.model.Rating
import com.example.bookreview.service.RatingService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    fun createRating(@Valid @RequestBody ratingRequest: RatingRequest): ResponseEntity<RatingResponse> {
        val createdRating = ratingService.createRating(ratingRequest)
        return ResponseEntity.ok(createdRating)
    }
}