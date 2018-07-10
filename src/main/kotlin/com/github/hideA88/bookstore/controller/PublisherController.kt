package com.github.hideA88.bookstore.controller


import com.github.hideA88.bookstore.model.domain.entity.Publisher
import com.github.hideA88.bookstore.model.domain.vo.PublisherId
import com.github.hideA88.bookstore.model.domain.vo.PublisherName
import com.github.hideA88.bookstore.model.service.PublisherService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "api/publisher")
class PublisherController(
    private val publisherService: PublisherService
){
    @GetMapping("/list")
    fun list(
        @RequestParam(name = "publisherName", required = false) publisherName: PublisherName?
    ): List<Publisher> {
        return publisherService.list(publisherName)
    }

    @RequestMapping("/findBy")
    fun findBy(
        @RequestParam("id") publisherId: PublisherId
    ): Publisher? {
        return publisherService.findBy(publisherId)
    }

    @PostMapping("/create")
    fun create(
        @RequestBody req: CreateRequest
    ): Publisher {
        val autorName = PublisherName(req.name)
        return publisherService.create(autorName)
    }

    //FIXME まとめて編集できるようにする？
    @PostMapping("/update")
    fun update(
        @RequestBody req: UpdateRequest
    ): Unit {
        val publisher = Publisher(PublisherId(req.id), PublisherName(req.name))
        return publisherService.update(publisher)
    }

    @DeleteMapping("/delete")
    fun delete(
        @RequestBody req: DeleteRequest
    ): Unit {
        val publisherId = PublisherId(req.id)
        publisherService.delete(publisherId)
    }

    companion object {
        data class CreateRequest(val name: String)
        data class UpdateRequest(val id: Long, val name: String)
        data class DeleteRequest(val id: Long)
    }
}
