package com.github.hideA88.bookstore.model.domain.repository.table

import org.jetbrains.exposed.sql.Table

object BookTable : Table() {
    val id   = long("id").primaryKey()
    val name = varchar("name", 255)
}
