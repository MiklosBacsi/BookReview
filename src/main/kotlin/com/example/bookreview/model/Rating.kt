package com.example.bookreview.model

import jakarta.persistence.*

@Entity
data class Rating(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val stars: Int,
    val rating: String,
    val author: String,

    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book
)
