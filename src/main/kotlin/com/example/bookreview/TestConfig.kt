package com.example.bookreview.config

import com.example.bookreview.model.Book
import com.example.bookreview.model.Rating
import com.example.bookreview.repository.BookRepository
import com.example.bookreview.repository.RatingRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestConfig {

    @Bean
    fun init(bookRepository: BookRepository, ratingRepository: RatingRepository): CommandLineRunner {
        return CommandLineRunner {
            val book1 = bookRepository.save(
                Book(
                    title = "The Great Gatsby",
                    author = "F. Scott Fitzgerald",
                    description = "A story of the fabulously wealthy Jay Gatsby and his love for Daisy Buchanan.",
                    year = 1925
                )
            )
            val book2 = bookRepository.save(
                Book(
                    title = "To Kill a Mockingbird",
                    author = "Harper Lee",
                    description = "A story about racial injustice and the loss of innocence in a small Southern town.",
                    year = 1960
                )
            )

            ratingRepository.saveAll(
                listOf(
                    Rating(stars = 5, rating = "Amazing book!", author = "Alice", book = book1),
                    Rating(stars = 4, rating = "Really enjoyed it.", author = "Bob", book = book1),
                    Rating(stars = 5, rating = "A masterpiece.", author = "Charlie", book = book2)
                )
            )
        }
    }
}