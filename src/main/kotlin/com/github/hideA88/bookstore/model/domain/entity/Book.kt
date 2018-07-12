package com.github.hideA88.bookstore.model.domain.entity

import com.github.hideA88.bookstore.model.domain.vo.BookId
import com.github.hideA88.bookstore.model.domain.vo.BookName
import com.github.hideA88.bookstore.model.domain.vo.AuthorId
import com.github.hideA88.bookstore.model.domain.vo.PublisherId

data class Book(
        val id: BookId,
        val name: BookName,
        val authorId: AuthorId,
        val publisherId: PublisherId
)
