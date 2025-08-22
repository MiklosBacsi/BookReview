package com.example.bookreview.repository

import com.example.bookreview.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
    fun findByTitleContainsIgnoreCase(title: String): List<Book>
}