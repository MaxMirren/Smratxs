package com.maxm.sorts.utils

import android.support.annotation.NonNull
import android.text.Html
import android.os.Build
import android.text.Spanned

internal class TextColorizer(@NonNull private val sourceString: String) {

    private lateinit var colorizedString: String
    private val test = "while (i < int_array.length) {<br>" +
            "                   &emsp;\'m\'<br>" +
            "                   &emsp;\"has been started\"<br>" +
            "                   &emsp;if (int_array[i] < int_array[i-1]) {<br>" +
            "                        &emsp;&emsp;temp = int_array[i - 1];<br>" +
            "                        &emsp;&emsp;'a'<br>" +
            "                        &emsp;&emsp;int_array[i - 1] = int_array[i];<br>" +
            "                        &emsp;&emsp;int_array[i] = temp;<br>" +
            "                        &emsp;&emsp;i = 1;<br>" +
            "                    &emsp;}<br>" +
            "                    &emsp;else {<br>" +
            "                        &emsp;&emsp;'x'<br>" +
            "                        &emsp;&emsp;i++;<br>" +
            "                    &emsp;}<br>" +
            "                    &emsp;\"has been finished\"<br>" +
            "                }"

    enum class Colors(val color: String) {
        KEY_WORDS("#FF6600"),
        VALS_VARS("#00FFB9"),
        STRINGS_CHARS("#42FF00")
    }

    enum class ReservedWords(val text: String, val htmlText: String) {
        VAR("var", "<font color='" + Colors.KEY_WORDS.color + "'>var</font>"),
        VAL("val", "<font color='" + Colors.KEY_WORDS.color + "'>val</font>"),
        FOR("for", "<font color='" + Colors.KEY_WORDS.color + "'>for</font>"),
        WHILE("while", "<font color='" + Colors.KEY_WORDS.color + "'>while</font>"),
        IF("if", "<font color='" + Colors.KEY_WORDS.color + "'>if</font>"),
        ELSE("else", "<font color='" + Colors.KEY_WORDS.color + "'>else</font>"),
        ARRAY("Array", "<font color='" + Colors.KEY_WORDS.color + "'>array</font>")
    }

    init {
        colorizeAndReplace()
    }

    /**
     * Colorizes by replacing some content to proper html tags
     */
    private fun colorizeAndReplace() {
        colorizedString = sourceString
        colorizeAllChars()
        colorizeAllStrings()
        colorizedString = colorizedString
            .replace(ReservedWords.VAR.text, ReservedWords.VAR.htmlText)
            .replace(ReservedWords.VAL.text, ReservedWords.VAL.htmlText)
            .replace(ReservedWords.FOR.text, ReservedWords.FOR.htmlText)
            .replace(ReservedWords.IF.text, ReservedWords.IF.htmlText)
            .replace(ReservedWords.WHILE.text, ReservedWords.WHILE.htmlText)
            .replace(ReservedWords.ELSE.text, ReservedWords.ELSE.htmlText)
    }


    private fun colorizeAllChars() {
        val charSingleQuote = '\''
        var i = 0
        while (i < colorizedString.length) {
            val char = colorizedString[i]
            if (char == charSingleQuote) {
                val toBeReplaced = colorizedString.substring(i, i + 3)
                val colorizedReplacement = getColorizedAsStringOrChar(toBeReplaced)
                colorizedString = colorizedString.replaceRange(i, i + 3, colorizedReplacement)
                i += (3 + colorizedReplacement.length)
                continue
            }
            i +=1
        }
    }


    private fun colorizeAllStrings(){
        val charDoubleQuote = '\"'
        var startPosition = -1
        var startHasBeenSet = false
        var i = 0
        while (i < colorizedString.length) {
            val char = colorizedString[i]
            if (char == charDoubleQuote) {
                if (startHasBeenSet) {
                    val toBeReplaced = colorizedString.substring(startPosition, i + 1)
                    val colorizedReplacement = getColorizedAsStringOrChar(toBeReplaced)
                    colorizedString = colorizedString.replaceRange(startPosition, i + 1, colorizedReplacement)
                    i += colorizedReplacement.length
                }
                else {
                    startPosition = i
                    i++
                }
                startHasBeenSet = startHasBeenSet.not()
                continue
            }
            i++
        }
    }

    private fun getColorizedAsStringOrChar(sourceString: String): String {
        return "<font color='" + Colors.STRINGS_CHARS.color + "'>" + sourceString + "</font>"
    }


    internal fun getColorizedText(): String {
        return colorizedString
    }
}