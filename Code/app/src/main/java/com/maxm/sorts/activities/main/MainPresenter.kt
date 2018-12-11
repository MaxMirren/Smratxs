package com.maxm.sorts.activities.main

import android.support.design.widget.NavigationView

class MainPresenter(private val view: ActivityMain) {

    private val model: MainModel = MainModel(view)

    /**
     * Initializes list of algorithms places in strings.xml
     */
    internal fun initializeAlgorithmsList() {
        model.initializeAlgorithmsList()
    }

    /**
     * Adds all items to navigation view
     */
    internal fun addAllItemsToNavigationView(navigationView: NavigationView) {
        model.addAllItemsToNavigationView(navigationView)
    }


}