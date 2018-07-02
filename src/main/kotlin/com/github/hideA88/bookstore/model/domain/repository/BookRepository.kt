package com.github.hideA88.bookstore.model.domain.repository

import com.github.hideA88.bookstore.model.domain.entity.*
import com.github.hideA88.bookstore.model.domain.repository.table.BookDataView
import com.github.hideA88.bookstore.model.domain.vo.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository

@Repository
class BookRepository {
    fun list(bookName: BookName?, authorName: AuthorName?, publisherName: PublisherName?): List<Book> {
        //TODO implement where句のくみたての実装
        return BookDataView.selectAll().orderBy(BookDataView.id).map { createBook(it) }
    }

    fun findBy(bookId: BookId): Book? {
        return BookDataView.select{BookDataView.id.eq(bookId.value)}
            .firstOrNull()?.let { createBook(it) }
    }

    fun save(bookName: BookName, authorId: AuthorId, publisherId: PublisherId): Book {
        TODO()
    }

    private fun createBook(row: ResultRow): Book {
        val author    = Author(AuthorId(row[BookDataView.authorId]), AuthorName(row[BookDataView.authorName]))
        val publisher = Publisher(PublisherId(row[BookDataView.publisherId]), PublisherName(row[BookDataView.publisherName]))
        return Book(BookId(row[BookDataView.id]),
            BookName(row[BookDataView.name]),
            author, publisher
        )
    }

}
