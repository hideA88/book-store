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
        @RequestBody req: CreateRequest
    ): Author {
        val autorName = AuthorName(req.name)
        return authorService.create(autorName)
    }

    //FIXME まとめて編集できるようにする？
    @PostMapping("/update")
    fun update(
        @RequestBody req: UpdateRequest
    ): Unit {
        val author = Author(AuthorId(req.id), AuthorName(req.name))
        return authorService.update(author)
    }

    @DeleteMapping("/delete")
    fun delete(
        @RequestBody req: DeleteRequest
    ): Unit {
        val authorId = AuthorId(req.id)
        authorService.delete(authorId)
    }

    companion object {
        data class CreateRequest(val name: String)
        data class UpdateRequest(val id: Long, val name: String)
        data class DeleteRequest(val id: Long)
    }
}
