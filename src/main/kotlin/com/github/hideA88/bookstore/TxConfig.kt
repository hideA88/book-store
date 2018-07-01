package com.github.hideA88.bookstore

import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class TxConfig(val dataSource: DataSource): TransactionManagementConfigurer {
    @Bean
    override fun annotationDrivenTransactionManager(): PlatformTransactionManager =
        SpringTransactionManager(dataSource)
}
