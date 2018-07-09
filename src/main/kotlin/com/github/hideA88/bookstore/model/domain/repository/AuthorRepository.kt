package com.github.hideA88.bookstore.model.domain.repository

import com.github.hideA88.bookstore.model.domain.entity.Author
import com.github.hideA88.bookstore.model.domain.repository.table.Authors
import com.github.hideA88.bookstore.model.domain.vo.AuthorId
import com.github.hideA88.bookstore.model.domain.vo.AuthorName
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository

@Repository
class AuthorRepository {
    fun list(authorName: AuthorName?): List<Author> {
        //TODO implement where句
        return Authors.selectAll().orderBy(Authors.id).map{getAuthor(it)}
    }

    fun findBy(authorId: AuthorId): Author? {
        return Authors.select{
            Authors.id.eq(authorId.value)
        }.firstOrNull()?.let { getAuthor(it) }
    }

    fun save(authorName: AuthorName): Author {
        val id = Authors.insertAndGetId {
            it[name] = authorName.value
        }
        return Author(AuthorId(id.value), authorName)
    }

    //TODO 成功か失敗かをどのように扱うべきなのか
    fun update(author: Author): Unit {
        Authors.update({Authors.id eq author.id.value}) {
            it[name] = author.name.value
        }
    }

    fun delete(authorId: AuthorId): Unit {
         Authors.deleteWhere{Authors.id eq authorId.value}
    }

    private fun getAuthor(row: ResultRow): Author {
        return Author(AuthorId(row[Authors.id].value), AuthorName(row[Authors.name]))
    }


}
