package com.example.bookreview.service

import com.example.bookreview.dto.BookRequest
import com.example.bookreview.dto.BookResponse
import com.example.bookreview.model.Book
import com.example.bookreview.repository.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<BookResponse> {
        return bookRepository.findAll().map { it.toResponse() }
    }

    fun getBookById(id: Long): BookResponse? {
        return bookRepository.findByIdOrNull(id)?.toResponse()
    }

    fun createBook(bookRequest: BookRequest): BookResponse {
        val book = Book(
            title = bookRequest.title,
            author = bookRequest.author,
            description = bookRequest.description,
            year = bookRequest.year
        )
        return bookRepository.save(book).toResponse()
    }

    fun searchBooks(query: String): List<BookResponse> {
        return bookRepository.findByTitleContainsIgnoreCase(query).map { it.toResponse() }
    }

    private fun Book.toResponse() = BookResponse(
        id = id,
        title = title,
        author = author,
        description = description,
        year = year,
        rating = ratings.takeIf { it.isNotEmpty() }?.let { it.sumOf { rating -> rating.stars } / it.size.toDouble() }
    )
}