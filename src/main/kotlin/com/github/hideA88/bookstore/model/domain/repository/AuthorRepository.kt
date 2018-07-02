package com.github.hideA88.bookstore.model.domain.repository

import com.github.hideA88.bookstore.model.domain.entity.Author
import com.github.hideA88.bookstore.model.domain.repository.table.Authors
import com.github.hideA88.bookstore.model.domain.vo.AuthorId
import com.github.hideA88.bookstore.model.domain.vo.AuthorName
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Repository

@Repository
class AuthorRepository {
    fun list(authorName: AuthorName?): List<Author> {
        return TODO()
    }

    fun findBy(authorId: AuthorId): Author? {
        return Authors.select{Authors.id.eq(authorId.value)}
                .firstOrNull()?.let { getAuthor(it) }
    }

    private fun getAuthor(row: ResultRow): Author {
        return Author(AuthorId(row[Authors.id]), AuthorName(row[Authors.name]))
    }
}
