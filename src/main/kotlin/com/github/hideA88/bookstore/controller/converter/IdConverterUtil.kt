package com.github.hideA88.bookstore.controller.converter

import com.github.hideA88.bookstore.model.domain.vo.*
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component


object IdConverterUtil {
    @Component
    class StringToBookIdConverter : Converter<String, BookId> {
        override fun convert(source: String): BookId? {
            return convertId(source) { BookId(it) }
        }
    }

    @Component
    class StringToAuthorIdConverter : Converter<String, AuthorId> {
        override fun convert(source: String): AuthorId? {
            return convertId(source) { AuthorId(it) }
        }
    }

    @Component
    class StringToPublisherIdConverter : Converter<String, PublisherId> {
        override fun convert(source: String): PublisherId? {
            return convertId(source) { PublisherId(it) }
        }
    }

    private fun <T> convertId(source: String, f: (Long) -> T): T? {
        //TODO implement ここでnullを返すとエラーになって500がかえってしまうので、いい感じにする必要がある
        return source.toLongOrNull()?.let { f(it) }
    }
}
