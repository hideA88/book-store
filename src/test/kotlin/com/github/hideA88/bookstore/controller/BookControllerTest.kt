package com.github.hideA88.bookstore.controller

import com.github.hideA88.bookstore.setup.CsvDataSetLoader
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener
import com.github.springtestdbunit.annotation.DatabaseOperation
import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.DbUnitConfiguration
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener


@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader::class, databaseConnection=arrayOf("mysqlDataSource"))
@DatabaseSetup(value = "/fixture/mysql/alert_timeline/i_alert_timeline.csv", type = DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners(
        DependencyInjectionTestExecutionListener::class,
        DirtiesContextTestExecutionListener::class,
        TransactionDbUnitTestExecutionListener::class
)

@RunWith(SpringRunner::class)
@SpringBootTest
class BookControllerTest {

//    @Autowired
//    lateinit var iAlertTimelineRepository: IAlertTimelineRepository
//
//    @Test
//    fun findOneById_IDで取得() {
//        val iAlertTimeline: IAlertTimeline = iAlertTimelineRepository.findOneById("1")
//        Assert.assertThat(iAlertTimeline.id, Matchers.`is`("1"))
    //}
}

