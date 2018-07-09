package com.github.hideA88.bookstore.model.domain.repository.table

import org.jetbrains.exposed.dao.LongIdTable

object Publishers : LongIdTable("publisher") {
    val name = varchar("name", 255)
}
