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
    fun list(bookName: BookName?, authorName: AuthorName?, publisherName: PublisherName?): List<BookData> {
        return bookRepository.list(bookName, authorName, publisherName)
    }

    fun findBy(bookId: BookId): BookData? {
        return bookRepository.findBy(bookId)
    }

    fun create(bookName: BookName, authorId: AuthorId, publisherId: PublisherId): BookData {
        return bookRepository.save(bookName, authorId, publisherId)
    }

    fun update(modifyBook: Book): Unit {
        return bookRepository.update(modifyBook)
    }

    fun delete(bookId: BookId): Unit {
        return bookRepository.delete(bookId)
    }
}
