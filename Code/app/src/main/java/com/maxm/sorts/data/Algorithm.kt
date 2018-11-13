package com.maxm.sorts.data

import android.support.annotation.StringRes
import java.util.*

data class Algorithm(val id: Int,
                     val name: String,
                     val description: String,
                     val code: String,
                     val debugger: String) {

    object List {
        private var list: LinkedList<Algorithm> = LinkedList()
        private var categories: LinkedList<Int> = LinkedList()
        private var categoryCounter = 0

        enum class Fields {
            NAME,
            DESCRIPTION,
            CODE,
            DEBUGGER
        }

        fun addCategory(@StringRes resId: Int) {
            categories.add(resId)
        }

        fun getCategoryByIndex(index: Int) = categories[index]

        fun getCategoriesSize() = categories.size

        fun addAlgorithm(algorithm: Algorithm) {
            list.add(algorithm)
        }

        fun getAllAlgorithmFieldsByIndex(index: Int) = list[index]

        fun getFieldOfAlgorithmWithIndex(index: Int, field: Fields) =
            when (field) {
                Fields.NAME -> list[index].name
                Fields.DESCRIPTION -> list[index].description
                Fields.CODE -> list[index].code
                Fields.DEBUGGER -> list[index].debugger
            }

        fun clearAll() {
            list.clear()
            categories.clear()
        }


    }
}