package com.maxm.sorts.utils

import android.support.annotation.NonNull
import com.maxm.sorts.views.FontFlexTextView

internal class LinesNumerator(
    @NonNull private var sourceString: String,
    @NonNull private val fontFlexTextView: FontFlexTextView) {

    private lateinit var numberLinesString: String
    private var linesCount: Int

    init {
        doIt()
        linesCount = fontFlexTextView.layout.lineCount
    }

    private fun doIt() {
        for (lineNumber in 0 until linesCount) {
            val lineStart = fontFlexTextView.layout.getLineStart(lineNumber)
            val lineEnd = fontFlexTextView.layout.getLineEnd(lineNumber)
            val line = fontFlexTextView.text.subSequence(lineStart, lineEnd).toString()
            sourceString = sourceString.replace(line, "${lineNumber + 1} " + line)
        }
        numberLinesString = sourceString
    }

    fun getNumberedLinesString(): String {
        return numberLinesString
    }




}