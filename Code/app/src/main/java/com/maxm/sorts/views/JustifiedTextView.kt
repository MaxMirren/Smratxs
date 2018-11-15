package com.maxm.sorts.views

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.AttributeSet
import com.maxm.sorts.views.Font

import com.uncopt.android.widget.text.justify.JustifiedTextView

internal class JustifiedTextView : JustifiedTextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    /**
     * Sets font for current object
     */
    fun setFont(assets: AssetManager, fontType: Font) {
        val font = Typeface.createFromAsset(assets, fontType.font)
        this.typeface = font
    }
}