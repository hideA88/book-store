package com.github.hideA88.bookstore.model.domain.entity

import com.github.hideA88.bookstore.model.domain.vo.PublisherId
import com.github.hideA88.bookstore.model.domain.vo.PublisherName

data class Publisher(
        val id: PublisherId,
        val name: PublisherName)
