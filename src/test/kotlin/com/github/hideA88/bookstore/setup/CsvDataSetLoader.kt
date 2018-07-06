package com.github.hideA88.bookstore.setup

import com.github.springtestdbunit.dataset.AbstractDataSetLoader
import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.csv.CsvURLDataSet
import org.springframework.core.io.Resource

class CsvDataSetLoader : AbstractDataSetLoader() {
    override fun createDataSet(resource: Resource): IDataSet {
        return CsvURLDataSet(resource.url)
    }
}