package com.maxm.sorts.data

import android.support.annotation.StringRes
import java.util.*

internal data class Algorithm(private val id: Int,
                              private val name: String,
                              private val description: String,
                              private val debugger: String) {

    object List {
        private var list: LinkedList<Algorithm> = LinkedList()
        private var categories: LinkedList<Int> = LinkedList()

        enum class Fields {
            NAME,
            DESCRIPTION,
            DEBUGGER
        }

        fun addCategory(@StringRes resId: Int) {
            categories.add(resId)
        }

        fun addAlgorithm(algorithm: Algorithm) {
            list.add(algorithm)
        }

        fun getAlgorithmsCount(): Int {
            return list.size
        }

        @Suppress("UNUSED")
        fun getCategoryByIndex(index: Int) = categories[index]

        fun getCategoriesSize() = categories.size

        @Suppress("UNUSED")
        fun getAllAlgorithmFieldsByIndex(index: Int) = list[index]

        fun getFieldOfAlgorithmWithIndex(index: Int, field: Fields) =
            when (field) {
                Fields.NAME -> list[index].name
                Fields.DESCRIPTION -> list[index].description
                Fields.DEBUGGER -> list[index].debugger
            }

        @Suppress("UNUSED")
        fun clearAll() {
            list.clear()
            categories.clear()
        }
    }
}