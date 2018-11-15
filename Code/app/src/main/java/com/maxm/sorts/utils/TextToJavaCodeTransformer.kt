package com.maxm.sorts.utils

import android.support.annotation.NonNull
import com.maxm.sorts.views.FontFlexTextView

internal class TextToJavaCodeTransformer(@NonNull private val sourceString: String,
                                         @NonNull private val fontFlexTextView: FontFlexTextView) {

    enum class Colors(val color: String) {
        KEY_WORDS("#FF6600"),
        VALS_VARS("#00FFB9"),
        CHARS("#42FF00")
    }

    init {
        //val numberedLinesString = LinesNumerator(sourceString, fontFlexTextView).getNumberedLinesString()
        //TextColorizer(numberedLinesString, fontFlexTextView).colorizedString
        TextColorizer(sourceString, fontFlexTextView).colorizedString
    }
}