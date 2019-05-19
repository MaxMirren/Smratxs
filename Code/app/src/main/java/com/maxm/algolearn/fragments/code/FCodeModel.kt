package com.maxm.algolearn.fragments.code

import android.util.DisplayMetrics
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.models.Algorithm.List.getAlgorithmsCount

class FCodeModel(private val fragmentCode: FragmentCode) {

    /**
     * Retrieves the first name and debug info of the first algorithm
     * @return map<name, debug info> of the first algorithm
     */
    internal fun getFirstNameAndDebugInfo(): HashMap<String, String> {
        val hashMap: HashMap<String, String> = HashMap()
        for (index in 0 until getAlgorithmsCount()) {
            val algorithmName = Algorithm.List.getStringFieldOfAlgorithmWithIndex(index, Algorithm.List.Fields.NAME)
            if (algorithmName.isNotEmpty()) {
                hashMap[algorithmName] = Algorithm.List.getStringFieldOfAlgorithmWithIndex(index, Algorithm.List.Fields.DEBUGGER)
                break
            }
        }
        return hashMap
    }


    /**
     * Converts dp to px
     * @param dp dp value to be converted to px value in float
     * @return Float value of converted px
     */
    internal fun convertDpToPixel(dp: Float): Float {
        val metrics = fragmentCode.context!!.resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}