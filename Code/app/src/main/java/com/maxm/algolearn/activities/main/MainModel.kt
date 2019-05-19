package com.maxm.algolearn.activities.main

import com.google.android.material.navigation.NavigationView
import com.maxm.algolearn.R
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.models.AlgorithmsListCreator
import com.maxm.algolearn.models.sortsCode
import com.maxm.algolearn.utils.TextColorizer
import com.maxm.algolearn.views.activities.ActivityMain

class MainModel(private val view: ActivityMain) {

    /**
     * Initializes list of algorithms places in strings.xml
     */
    internal fun initializeAlgorithmsList() {
        val namesArray = view.resources.getStringArray(R.array.sorts_names)
        val descriptionArray = view.resources.getStringArray(R.array.sorts_description)
        val characteristicsArray = view.resources.getStringArray(R.array.sorts_description)
        val demosArray = view.resources.getStringArray(R.array.sorts_description)
        val debuggerArray = view.resources.getStringArray(R.array.sorts_debugs)
        AlgorithmsListCreator(namesArray, descriptionArray, characteristicsArray, demosArray, debuggerArray)
        for (key in sortsCode.keys) {
            sortsCode[key] = TextColorizer(sortsCode.getValue(key)).getColorizedText()
        }
    }

    /**
     * Adds all items to navigation view
     */
    internal fun addAllItemsToNavigationView(navigationView: NavigationView) {
        for (i in 0 until Algorithm.List.getAlgorithmsCount()) {
            val name = Algorithm.List.getStringFieldOfAlgorithmWithIndex(i, Algorithm.List.Fields.NAME)
            val toBePasteName = if (name != "-") name else ""
            navigationView.menu.add(0, i, 0, toBePasteName)
        }
    }

}