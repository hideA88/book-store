package com.github.hideA88.bookstore.model.domain.repository

import com.github.hideA88.bookstore.model.domain.entity.Publisher
import com.github.hideA88.bookstore.model.domain.repository.table.Publishers
import com.github.hideA88.bookstore.model.domain.vo.PublisherId
import com.github.hideA88.bookstore.model.domain.vo.PublisherName
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository


@Repository
class PublisherRepository {
    fun list(publisherName: PublisherName?): List<Publisher> {
        //TODO implement where句
        return Publishers.selectAll().orderBy(Publishers.id).map{getPublisher(it)}
    }

    fun findBy(publisherId: PublisherId): Publisher? {
        return Publishers.select{
            Publishers.id.eq(publisherId.value)
        }.firstOrNull()?.let { getPublisher(it) }
    }

    fun save(publisherName: PublisherName): Publisher {
        val id = Publishers.insertAndGetId {
            it[name] = publisherName.value
        }
        return Publisher(PublisherId(id.value), publisherName)
    }

    //TODO 成功か失敗かをどのように扱うべきなのか
    fun update(publisher: Publisher): Unit {
        Publishers.update({ Publishers.id eq publisher.id.value}) {
            it[name] = publisher.name.value
        }
    }

    fun delete(publisherId: PublisherId): Unit {
        Publishers.deleteWhere{ Publishers.id eq publisherId.value}
    }

    private fun getPublisher(row: ResultRow): Publisher {
        return Publisher(PublisherId(row[Publishers.id].value), PublisherName(row[Publishers.name]))
    }


}
