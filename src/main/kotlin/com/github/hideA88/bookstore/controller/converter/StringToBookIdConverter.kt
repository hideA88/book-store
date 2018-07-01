package com.github.hideA88.bookstore.controller.converter

import com.github.hideA88.bookstore.model.domain.vo.BookId
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class StringToBookIdConverter : Converter<String, BookId>{
    override fun convert(source: String): BookId? {
        //TODO implement ここでnullを返すとエラーになって500がかえってしまうので、いい感じにする必要がある
        return source.toLongOrNull()?.let { BookId(it) }
    }
}
