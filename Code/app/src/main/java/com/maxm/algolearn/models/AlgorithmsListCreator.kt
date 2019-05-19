package com.maxm.algolearn.models

internal class AlgorithmsListCreator(private val namesArray: Array<String>,
                            private val descriptionArray: Array<String>,
                            private val characteristicsArray: Array<String>,
                            private val demosArray: Array<String>,
                            private val debuggerArray: Array<String>) {
    init {
//        if (allArraysAreEqual()) {
            addAllArrays()
//        }
    }

    private fun allArraysAreEqual() = ((namesArray.size == descriptionArray.size) and
            (namesArray.size == sortsCode.size) and (namesArray.size == debuggerArray.size))

    private fun addAllArrays() {
        var index = 0
        var catsCount = 0
        while (index < namesArray.size) {
            if (namesArray[index].startsWith('#')) {
                Algorithm.List.addCategory(namesArray[index].substring(1))
                catsCount++
                Algorithm.List.addAlgorithm(Algorithm(catsCount, "", "",  "", "", ""))
            }
            else {
                Algorithm.List.addAlgorithm(Algorithm(catsCount,
                    namesArray[index],
                    descriptionArray[index - catsCount],
                    characteristicsArray[index - catsCount],
                    demosArray[index - catsCount],
                    debuggerArray[index - catsCount]))
            }
            index++
        }
    }

}