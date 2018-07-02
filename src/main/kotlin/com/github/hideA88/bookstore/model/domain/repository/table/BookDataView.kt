package com.github.hideA88.bookstore.model.domain.repository.table

import org.jetbrains.exposed.sql.Table

object BookDataView: Table("bookdata") {
    val id            = long("id")
    val name          = varchar("name", 255)
    val authorId      = long("author_id")
    val authorName    = varchar("author_name", 255)
    val publisherId   = long("publisher_id")
    val publisherName = varchar("publisher_name", 255)
}
