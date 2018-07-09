package com.github.hideA88.bookstore.controller

import com.github.hideA88.bookstore.model.domain.entity.*
import com.github.hideA88.bookstore.model.domain.vo.*
import com.github.hideA88.bookstore.model.service.BookStoreService
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
    ): List<Book> {
        return bookService.list(bookName, authorName, publisherName)
    }

    @RequestMapping("/findBy")
    fun findBy(
        @RequestParam("id") bookId: BookId
    ): Book? {
        return bookService.findBy(bookId)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody req: BookRequest
    ): Book {
        return bookService.create(req.name, req.author.id, req.publisher.id)
    }

    @PostMapping("/update")
    fun update(
    ): Book {
        return TODO("implement")
    }

    @DeleteMapping("/delete")
    fun delete(
    ): Unit {
        //TODO delete時に返却するのはstatus 200だけでいい気がする。だとするとdeleteメソッドでよい？
        return TODO("implement")
    }

    companion object {
        data class BookRequest(val name: BookName, val author: Author, val publisher: Publisher)
    }
}



