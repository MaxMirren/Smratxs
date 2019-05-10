package com.maxm.sorts.activities.main

import com.google.android.material.navigation.NavigationView
import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.data.AlgorithmsListCreator
import com.maxm.sorts.data.sortsCode
import com.maxm.sorts.utils.TextColorizer

class MainModel(private val view: ActivityMain) {

    /**
     * Initializes list of algorithms places in strings.xml
     */
    internal fun initializeAlgorithmsList() {
        val namesArray = view.resources.getStringArray(R.array.sorts_names)
        val descriptionArray = view.resources.getStringArray(R.array.sorts_description)
        val debuggerArray = view.resources.getStringArray(R.array.sorts_debugs)
        AlgorithmsListCreator(namesArray, descriptionArray, debuggerArray, R.string.category_0)
        for (key in sortsCode.keys) {
            sortsCode[key] = TextColorizer(sortsCode.getValue(key)).getColorizedText()
        }
    }

    /**
     * Adds all items to navigation view
     */
    internal fun addAllItemsToNavigationView(navigationView: NavigationView) {
        for (i in 0 until Algorithm.List.getAlgorithmsCount()) {
            navigationView.menu.add(0, i, 0,
                Algorithm.List.getFieldOfAlgorithmWithIndex(i, Algorithm.List.Fields.NAME))
        }
    }


}