package com.maxm.sorts.fragments.code

import android.view.View

class FCodePresenter(private val fragmentCode: FragmentCode,
                     private val fragmentCodeView: View) {

    private val model = FCodeModel(fragmentCode)

    /**
     * Initializes view with data of the first algorithm
     */
    internal fun setContentOfTheFirstAlgorithm() {
        val hashMap = model.getFirstNameAndDebugInfo().entries.iterator().next()
        fragmentCode.setContent(hashMap.key, hashMap.value)
    }

    /**
     * Returns dp represented in px
     */
    internal fun getDPInPX(dp: Float): Float {
        return model.convertDpToPixel(dp)
    }
}