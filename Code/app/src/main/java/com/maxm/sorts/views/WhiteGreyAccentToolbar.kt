package com.maxm.sorts.views

import android.content.Context
import android.support.annotation.Nullable
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import com.maxm.sorts.R

class WhiteGreyAccentToolbar: Toolbar {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)

    constructor(context: Context, @Nullable attributeSet: AttributeSet, defStyleAttributeSet: Int):
            super(context, attributeSet, defStyleAttributeSet)

    /**
     * Sets bottom app bar background white or grey
     * @param white if is true then background os to be set partly in white color otherwise in grey
     */
    internal fun setBottomAppBarBackgroundWhite(white: Boolean) {
        val res = if (white) {
            R.drawable.main_bab_background_white
        }
        else {
            R.drawable.main_bab_background_grey
        }
        background = resources.getDrawable(res, resources.newTheme())
    }

}