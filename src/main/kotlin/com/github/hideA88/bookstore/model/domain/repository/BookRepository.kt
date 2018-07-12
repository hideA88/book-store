package com.github.hideA88.bookstore.model.domain.repository

import com.github.hideA88.bookstore.model.domain.entity.*
import com.github.hideA88.bookstore.model.domain.repository.table.BookDataView
import com.github.hideA88.bookstore.model.domain.repository.table.Books
import com.github.hideA88.bookstore.model.domain.vo.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository

@Repository
class BookRepository {
    fun list(bookName: BookName?, authorName: AuthorName?, publisherName: PublisherName?): List<BookData> {
        val bookNameQuery      = bookName?.     let{BookDataView.name          like "%${bookName.value}%"}
        val authorNameQuery    = authorName?.   let{BookDataView.authorName    like "%${authorName.value}%"}
        val publisherNameQuery = publisherName?.let{BookDataView.publisherName like "%${publisherName.value}%"}
        val queries = listOfNotNull(
            bookNameQuery,
            authorNameQuery,
            publisherNameQuery
        )
        val whereQuery = if(queries.isNotEmpty()) queries.reduce{ q1, q2 -> q1.and(q2)} else null

        val selectQuery = whereQuery?.let{BookDataView.select(whereQuery)} ?: BookDataView.selectAll()
        return selectQuery.orderBy(BookDataView.id).map{getBook(it)}
    }

    fun findBy(bookId: BookId): BookData? {
        return BookDataView.select{BookDataView.id.eq(bookId.value)}
            .firstOrNull()?.let { getBook(it) }
    }

    fun save(bookName: BookName, authorId_: AuthorId, publisherId_: PublisherId): BookData {
        val id = Books.insertAndGetId {
            it[name] = bookName.value
            it[authorId] = authorId_.value
            it[publisherId] = publisherId_.value
        }

        return this.findBy(BookId(id.value)) ?: throw Exception()
    }


    fun update(modifyBook: Book): Unit {
        Books.update({Books.id eq modifyBook.id.value}) {
            it[name] = modifyBook.name.value
            it[authorId] = modifyBook.authorId.value
            it[publisherId] = modifyBook.publisherId.value
        }
    }


    fun delete(bookId: BookId): Unit {
        Books.deleteWhere { Books.id eq bookId.value }
    }


    private fun getBook(row: ResultRow): BookData {
        val author    = Author(AuthorId(row[BookDataView.authorId]), AuthorName(row[BookDataView.authorName]))
        val publisher = Publisher(PublisherId(row[BookDataView.publisherId]), PublisherName(row[BookDataView.publisherName]))
        return BookData(BookId(row[BookDataView.id]),
            BookName(row[BookDataView.name]),
            author, publisher
        )
    }


}
