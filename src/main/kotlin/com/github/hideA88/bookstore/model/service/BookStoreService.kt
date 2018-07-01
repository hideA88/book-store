package com.github.hideA88.bookstore.model.service

import com.github.hideA88.bookstore.model.domain.entity.*
import com.github.hideA88.bookstore.model.domain.vo.*
import org.springframework.stereotype.Service

@Service
class BookStoreService {
    fun list(bookName: BookName?, authorName: AuthorName?, publisherName: PublisherName?): List<Book> {
        //TODO implement
        return listOf(getMockBook())
    }

    fun findBy(bookId: BookId): Book {
        //TODO
        return getMockBook(bookId)
    }

    fun create(name: BookName, id: AuthorId, id2: PublisherId): Book {
        //TODO implement controller用のbookとかつくらないといけなさそう
        //
        return TODO()
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
