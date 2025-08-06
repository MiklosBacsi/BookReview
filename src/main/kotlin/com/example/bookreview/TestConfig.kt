package com.example.bookreview

import com.example.bookreview.model.Book
import com.example.bookreview.repository.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TestConfig(private val bookRepository: BookRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        bookRepository.saveAll(
            listOf(
                Book(
                    title = "The Great Gatsby",
                    author = "F. Scott Fitzgerald",
                    description = "A story of the fabulously wealthy Jay Gatsby and his love for Daisy Buchanan.",
                    rating = 4.5,
                    year = 1925
                ),
                Book(
                    title = "To Kill a Mockingbird",
                    author = "Harper Lee",
                    description = "A story about racial injustice and the loss of innocence in a small Southern town.",
                    rating = 4.8,
                    year = 1960
                ),
                Book(
                    title = "1984",
                    author = "George Orwell",
                    description = "A dystopian novel about totalitarianism and surveillance.",
                    rating = 4.7,
                    year = 1949
                ),
                Book(
                    title = "Pride and Prejudice",
                    author = "Jane Austen",
                    description = "A romantic novel exploring love, class, and social expectations.",
                    rating = 4.6,
                    year = 1813
                )
            )
        )
    }
}