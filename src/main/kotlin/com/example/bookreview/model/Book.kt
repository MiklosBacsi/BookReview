package com.example.bookreview.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val author: String,
    val description: String,
    @Column(name = "`year`")
    val year: Int,

    @OneToMany(mappedBy = "book")
    val ratings: List<Rating> = emptyList()
)
