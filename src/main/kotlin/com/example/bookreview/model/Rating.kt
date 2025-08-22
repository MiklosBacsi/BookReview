package com.example.bookreview.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.JoinColumn

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
