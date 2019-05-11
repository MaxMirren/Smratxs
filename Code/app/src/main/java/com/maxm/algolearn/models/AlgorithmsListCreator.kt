package com.maxm.algolearn.models

import androidx.annotation.StringRes

internal class AlgorithmsListCreator(private val namesArray: Array<String>,
                            private val descriptionArray: Array<String>,
                            private val characteristicsArray: Array<String>,
                            private val demosArray: Array<String>,
                            private val debuggerArray: Array<String>,
                            @StringRes private val categoryResId: Int) {
    init {
//        if (allArraysAreEqual()) {
            addAllArrays()
//        }
    }

    private fun allArraysAreEqual() = ((namesArray.size == descriptionArray.size) and
            (namesArray.size == sortsCode.size) and (namesArray.size == debuggerArray.size))

    private fun addAllArrays() {
        Algorithm.List.addCategory(categoryResId)
        val categoriesSize = Algorithm.List.getCategoriesSize() - 1
        var index = 0
        var realSize = namesArray.size
        while (index < realSize) {
            if (namesArray[index] != "-") {
                Algorithm.List.addAlgorithm(Algorithm(categoriesSize, namesArray[index], descriptionArray[index],  characteristicsArray[index], demosArray[index], debuggerArray[index]))
            } else {
                Algorithm.List.addAlgorithm(Algorithm(categoriesSize, "", "",  "", "", ""))
                realSize--
            }
            index++
        }
    }

}