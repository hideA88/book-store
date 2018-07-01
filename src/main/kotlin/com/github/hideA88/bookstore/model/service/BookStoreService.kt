package com.github.hideA88.bookstore.model.service

import com.github.hideA88.bookstore.model.domain.entity.*
import com.github.hideA88.bookstore.model.domain.repository.BookRepository
import com.github.hideA88.bookstore.model.domain.vo.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class BookStoreService(
    private val bookRepository: BookRepository
) {
    fun list(bookName: BookName?, authorName: AuthorName?, publisherName: PublisherName?): List<Book> {
        return bookRepository.list(bookName, authorName, publisherName)
    }

    fun findBy(bookId: BookId): Book? {
        return bookRepository.findBy(bookId)
    }

    fun create(bookName: BookName, authorId: AuthorId, publisherId: PublisherId): Book {
        return bookRepository.save(bookName, authorId, publisherId)
    }

    fun update(): Book {
        return TODO()
    }

    fun delete(): Unit {
        TODO()
    }

    private fun getMockBook(bookId: BookId = BookId(1)): Book {
        return Book(bookId, BookName("hoge"),
            Author(AuthorId(1), AuthorName("fuga")),
            Publisher(PublisherId(1), PublisherName("piyo")))
    }
}
