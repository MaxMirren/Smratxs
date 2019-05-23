package com.maxm.algolearn.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.models.FCodeModel
import com.maxm.algolearn.models.sortsCode

class FCodeViewModel: ViewModel() {

    val currentFCodeModel: ObservableField<FCodeModel> = ObservableField()

    fun setDefaultAlgorithmContent() {
        val modelData = getCodeAndDebug().entries.iterator().next()
        val fCodeModel = FCodeModel.Builder()
            .code(modelData.key)
            .debug(modelData.value)
            .build()
        currentFCodeModel.set(fCodeModel)
    }

    /**
     * Retrieves the first name and debug info of the first algorithm
     * @return map<name, debug info> of the first algorithm
     */
    private fun getCodeAndDebug(): HashMap<String, String> {
        val hashMap: HashMap<String, String> = HashMap()
        for (index in 0 until Algorithm.List.getAlgorithmsCount()) {
            val algorithmName = Algorithm.List.getStringFieldOfAlgorithmWithIndex(index, Algorithm.List.Fields.NAME)
            if (algorithmName.isNotEmpty()) {
                hashMap[sortsCode.getValue(algorithmName)] = Algorithm.List.getStringFieldOfAlgorithmWithIndex(index, Algorithm.List.Fields.DEBUGGER)
                break
            }
        }
        return hashMap
    }
}