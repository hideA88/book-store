package com.github.hideA88.bookstore.model.service

import com.github.hideA88.bookstore.model.domain.entity.Publisher
import com.github.hideA88.bookstore.model.domain.repository.PublisherRepository
import com.github.hideA88.bookstore.model.domain.vo.PublisherId
import com.github.hideA88.bookstore.model.domain.vo.PublisherName
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class PublisherService(
    private val publisherRepository: PublisherRepository
) {
    fun list(publisherName: PublisherName?): List<Publisher>{
        return publisherRepository.list(publisherName)
    }

    fun findBy(publisherId: PublisherId): Publisher? {
        return publisherRepository.findBy(publisherId)
    }

    fun create(publisherName: PublisherName): Publisher {
        return publisherRepository.save(publisherName)
    }

    fun update(publisher: Publisher): Unit {
        return publisherRepository.update(publisher)
    }

    fun delete(publisherId: PublisherId) {
        return publisherRepository.delete(publisherId)
    }

}
