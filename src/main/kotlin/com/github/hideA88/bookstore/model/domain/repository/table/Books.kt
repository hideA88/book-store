package com.github.hideA88.bookstore.model.domain.repository.table

import org.jetbrains.exposed.dao.LongIdTable

object Books : LongIdTable("book") {
    val name = varchar("name", 255)
    val authorId = long("author_id")
    val publisherId = long("publisher_id")
}
