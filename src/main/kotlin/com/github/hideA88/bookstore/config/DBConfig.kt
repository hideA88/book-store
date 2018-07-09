package com.github.hideA88.bookstore.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.core.env.Environment
import org.springframework.core.env.get

@Configuration
class DBConfig(private val env: Environment) {
    @Bean
    fun dataSource(): DataSource {
        val config = HikariConfig()
        config.driverClassName = env["spring.datasource.driverClassName"]
        config.jdbcUrl         = env["spring.datasource.url"]
        config.username        = env["spring.datasource.username"]
        config.password        = env["spring.datasource.password"]
        config.connectionInitSql = "select 1"
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "250")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")

        return HikariDataSource(config)
    }
}
