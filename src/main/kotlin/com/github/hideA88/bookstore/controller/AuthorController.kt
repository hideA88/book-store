package com.github.hideA88.bookstore.controller

import com.github.hideA88.bookstore.model.domain.entity.Author
import com.github.hideA88.bookstore.model.domain.vo.AuthorId
import com.github.hideA88.bookstore.model.domain.vo.AuthorName
import com.github.hideA88.bookstore.model.service.AuthorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "api/author")
class AuthorController(
    private val authorService: AuthorService
){
    @GetMapping("/list")
    fun list(
        @RequestParam(name = "authorName", required = false) authorName: AuthorName?
    ): List<Author> {
        return authorService.list(authorName)
    }

    @RequestMapping("/findBy")
    fun findBy(
        @RequestParam("id") authorId: AuthorId
    ): Author? {
        return authorService.findBy(authorId)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody req: AuthorRequest
    ): Author {
        val autorName = AuthorName(req.name)
        return authorService.create(autorName)
    }

    @PostMapping("/update")
    fun update(
    ): Unit {
        return TODO("implement")
    }

    @DeleteMapping("/delete")
    fun delete(
    ): Unit {
        //TODO delete時に返却するのはstatus 200だけでいい気がする。だとするとdeleteメソッドでよい？
        return TODO("implement")
    }

    companion object {
        data class AuthorRequest(val name: String)
    }
}
