package com.github.hideA88.bookstore.controller.converter

import com.github.hideA88.bookstore.model.domain.vo.*
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

object NameConverterUtil {
    @Component
    class StringToBookNameConverter : Converter<String, BookName> {
        override fun convert(source: String): BookName {
            return BookName(source)
        }
    }

    @Component
    class StringToAuthorNameConverter : Converter<String, AuthorName> {
        override fun convert(source: String): AuthorName {
            return AuthorName(source)
        }
    }

    @Component
    class StringToPublisherNameConverter : Converter<String, PublisherName> {
        override fun convert(source: String): PublisherName {
            return PublisherName(source)
        }
    }
}
