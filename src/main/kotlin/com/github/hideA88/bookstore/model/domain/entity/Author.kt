package com.github.hideA88.bookstore.model.domain.entity

import com.github.hideA88.bookstore.model.domain.vo.AuthorId
import com.github.hideA88.bookstore.model.domain.vo.AuthorName

data class Author(
        val id: AuthorId,
        val name: AuthorName)
