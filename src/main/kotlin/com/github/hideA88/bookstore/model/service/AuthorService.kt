package com.github.hideA88.bookstore.model.service

import com.github.hideA88.bookstore.model.domain.entity.Author
import com.github.hideA88.bookstore.model.domain.repository.AuthorRepository
import com.github.hideA88.bookstore.model.domain.vo.AuthorId
import com.github.hideA88.bookstore.model.domain.vo.AuthorName
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {
    fun list(authorName: AuthorName?): List<Author>{
        return authorRepository.list(authorName)
    }

    fun findBy(authorId: AuthorId): Author? {
        return authorRepository.findBy(authorId)
    }

    fun create(authorName: AuthorName): Author {
        return authorRepository.save(authorName)
    }

    fun update(author: Author): Unit {
        return authorRepository.update(author)
    }

}
