package com.github.hideA88.bookstore.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DBConfig(private val env: Environment) {
    //TODO connection poolの設定も必要そう？
    @Bean
    fun dataSource(): DataSource {
        var source = DriverManagerDataSource()
        source.setDriverClassName(env.get("spring.datasource.driverClassName"))
        source.url = env.get("spring.datasource.url")
        source.username = env.get("spring.datasource.username")
        source.password = env.get("spring.datasource.password")
        return source
    }
}