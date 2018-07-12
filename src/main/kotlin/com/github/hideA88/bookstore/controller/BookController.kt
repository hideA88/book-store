package com.github.hideA88.bookstore.controller

import com.github.hideA88.bookstore.model.domain.entity.*
import com.github.hideA88.bookstore.model.domain.vo.*
import com.github.hideA88.bookstore.model.service.BookStoreService
import com.mysql.cj.x.protobuf.MysqlxCrud
import org.springframework.web.bind.annotation.*


//TODO error handler
@RestController
@RequestMapping(value = "api/book")
class BookController(
    private val bookService: BookStoreService
) {
    @GetMapping("/list")
    fun list(
        @RequestParam(name = "bookName",      required = false) bookName:      BookName?,
        @RequestParam(name = "authorName",    required = false) authorName:    AuthorName?,
        @RequestParam(name = "publisherName", required = false) publisherName: PublisherName?
    ): List<BookData> {
        return bookService.list(bookName, authorName, publisherName)
    }

    @RequestMapping("/findBy")
    fun findBy(
        @RequestParam("id") bookId: BookId
    ): BookData? {
        return bookService.findBy(bookId)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody req: CreateRequest
    ): BookData {
        return bookService.create(BookName(req.name), AuthorId(req.authorId), PublisherId(req.publisherId))
    }

    @PostMapping("/update")
    fun update(
        @RequestBody req: UpdateRequest
    ): Unit {
        val book = Book(BookId(req.id), BookName(req.name), AuthorId(req.authorId), PublisherId(req.publisherId))
        return bookService.update(book)
    }

    @DeleteMapping("/delete")
    fun delete(
        @RequestBody req: DeleteRequest
    ): Unit {
        return bookService.delete(BookId(req.id))
    }

    companion object {
        data class CreateRequest(val name: String, val authorId: Long, val publisherId: Long)
        data class UpdateRequest(val id: Long, val name: String, val authorId: Long, val publisherId: Long)
        data class DeleteRequest(val id: Long)
    }
}



