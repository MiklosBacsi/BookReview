package com.example.bookreview

import com.example.bookreview.model.Book
import com.example.bookreview.repository.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BookReviewApplication

fun main(args: Array<String>) {
    runApplication<BookReviewApplication>(*args)
}
