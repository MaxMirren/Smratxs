package com.maxm.algolearn.views.custom

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater

import com.uncopt.android.widget.text.justify.JustifiedTextView

internal class JustifiedFontFlexTextView : JustifiedTextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    init {
        this.typeface = Typeface.createFromAsset(context.assets, Font.RUBIK_REGULAR.font)
    }
}