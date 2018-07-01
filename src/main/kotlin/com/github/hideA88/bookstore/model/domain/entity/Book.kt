package com.github.hideA88.bookstore.model.domain.entity

import com.github.hideA88.bookstore.model.domain.vo.BookId
import com.github.hideA88.bookstore.model.domain.vo.BookName

data class Book(
        val id: BookId,
        val name: BookName,
        val author: Author,
        val publisher: Publisher
)
