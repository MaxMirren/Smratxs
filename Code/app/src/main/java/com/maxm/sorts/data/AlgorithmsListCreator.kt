package com.maxm.sorts.data

import android.support.annotation.StringRes

class AlgorithmsListCreator(private val namesArray: Array<String>,
                            private val descriptionArray: Array<String>,
                            private val codeArray: Array<String>,
                            private val debuggerArray: Array<String>,
                            @StringRes private val categoryResId: Int) {
    init {
        if (allArraysAreEqual()) {
            addAllArrays()
        }
    }

    private fun allArraysAreEqual() = ((namesArray.size == descriptionArray.size) and
            (namesArray.size == codeArray.size) and (namesArray.size == debuggerArray.size))

    private fun addAllArrays() {
        Algorithm.List.addCategory(categoryResId)
        val categoriesSize = Algorithm.List.getCategoriesSize() - 1
        for (i in 0 until namesArray.size) {
            Algorithm.List.addAlgorithm(
                Algorithm(categoriesSize, namesArray[i], descriptionArray[i], codeArray[i], debuggerArray[i]))
        }
    }

}