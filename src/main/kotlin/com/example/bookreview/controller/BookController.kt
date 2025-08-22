package com.example.bookreview.controller

import com.example.bookreview.dto.BookRequest
import com.example.bookreview.dto.BookResponse
import jakarta.validation.Valid
import com.example.bookreview.model.Book
import com.example.bookreview.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class BookController(private val bookService: BookService) {

    @GetMapping("/books")
    fun getAllBooks(): List<BookResponse> {
        return bookService.getAllBooks()
    }

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<BookResponse> {
        val book = bookService.getBookById(id)
        return (if (book != null) {
            ResponseEntity.ok(book)
        } else {
            ResponseEntity.notFound().build()
        })
    }

    @PostMapping("/book")
    fun createBook(@Valid @RequestBody request: BookRequest): ResponseEntity<BookResponse> {
        val createdBook = bookService.createBook(request)
        return ResponseEntity.ok(createdBook)
    }

    @GetMapping("/books/search")
    fun searchBooks(@RequestParam query: String): List<BookResponse> {
        return bookService.searchBooks(query)
    }
}