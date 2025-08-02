package com.example.bookreview.service

import com.example.bookreview.model.Book
import com.example.bookreview.repository.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book? {
        return bookRepository.findByIdOrNull(id)
    }

}