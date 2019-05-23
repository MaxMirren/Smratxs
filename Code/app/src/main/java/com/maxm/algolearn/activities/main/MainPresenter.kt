package com.maxm.algolearn.activities.main

import android.content.Context
import com.google.android.material.navigation.NavigationView
import com.maxm.algolearn.fragments.FragmentDescription
import com.maxm.algolearn.fragments.code.FragmentCode
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.models.FCodeModel
import com.maxm.algolearn.models.FDescriptionModel
import com.maxm.algolearn.models.sortsCode
import com.maxm.algolearn.utils.TextColorizer

class MainPresenter(context: Context) {

    private val model: MainModel = MainModel(context)

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

    internal fun updateCurrentFragmentsModels(algorithmName: String,
                                              fragmentDescription: FragmentDescription,
                                              fragmentCode: FragmentCode,
                                              itemId: Int) {
        val algorithmDescription =
            Algorithm.List.getStringFieldOfAlgorithmWithIndex(itemId, Algorithm.List.Fields.DESCRIPTION)
        val algorithmCharacteristics =
            Algorithm.List.getStringFieldOfAlgorithmWithIndex(itemId, Algorithm.List.Fields.CHARACTERISTICS)
        val algorithmImgRes =
            Algorithm.List.getStringFieldOfAlgorithmWithIndex(itemId, Algorithm.List.Fields.DEMO)
        val fDescriptionModel = FDescriptionModel.Builder()
            .description(algorithmDescription)
            .characteristics(algorithmCharacteristics)
            .imgAssetPath(algorithmImgRes)
            .build()
        fragmentDescription.viewModel.currentFDescriptionModel.set(fDescriptionModel)
        val algorithmDebugger =
            Algorithm.List.getStringFieldOfAlgorithmWithIndex(itemId, Algorithm.List.Fields.DEBUGGER)
        val fCodeModel = FCodeModel.Builder()
            .code(sortsCode.getValue(algorithmName))
            .debug(TextColorizer(algorithmDebugger).getColorizedText())
            .build()
        fragmentCode.viewModel.currentFCodeModel.set(fCodeModel)
        fragmentCode.setProperHeightsForCards()
    }

}