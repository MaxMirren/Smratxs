package com.maxm.algolearn.fragments.code

import android.util.DisplayMetrics
import com.maxm.algolearn.models.Algorithm

class FCodeModel(private val fragmentCode: FragmentCode) {

    /**
     * Retrieves the first name and debug info of the first algorithm
     * @return map<name, debug info> of the first algorithm
     */
    internal fun getFirstNameAndDebugInfo(): HashMap<String, String> {
        val algorithmName = Algorithm.List.getStringFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        val algorithmDebugger = Algorithm.List.getStringFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DEBUGGER)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap[algorithmName] = algorithmDebugger
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