package com.maxm.algolearn.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.models.FDescriptionModel

class FDescriptionViewModel: ViewModel() {

    val currentFDescriptionModel: ObservableField<FDescriptionModel> = ObservableField()

    fun setDefaultDescriptionData() {
        val description = Algorithm.List.getStringFieldOfAlgorithmWithIndex(1, Algorithm.List.Fields.DESCRIPTION)
        val characteristics = Algorithm.List.getStringFieldOfAlgorithmWithIndex(1, Algorithm.List.Fields.CHARACTERISTICS)
        val demo = Algorithm.List.getStringFieldOfAlgorithmWithIndex(1, Algorithm.List.Fields.DEMO)
        val fDescriptionModel = FDescriptionModel.Builder()
            .description(description)
            .characteristics(characteristics)
            .imgAssetPath(demo)
            .build()
        currentFDescriptionModel.set(fDescriptionModel)
    }
}