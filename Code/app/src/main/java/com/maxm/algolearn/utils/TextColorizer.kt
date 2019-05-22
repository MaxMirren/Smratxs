package com.maxm.algolearn.utils

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.annotation.NonNull

/**
 * Gets spanned content from HTML in two ways in dependence on Android version
 * @param html is string data which is to be converted to spanned html data
 * @suppress using Html.fromHtml method for Android versions under Marshmallow
 */
@Suppress("DEPRECATION")
fun fromHtml(html: String): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(html)
    }
}

internal class TextColorizer(@NonNull private val sourceString: String) {

    private lateinit var colorizedString: String

    private enum class Colors(val hexCode: String) {
        RESERVED("#FF6600"),
        NUMBERS("#00FFB9"),
        STRINGS_CHARS("#42FF00")
    }

    private enum class Reserved(val text: String, val htmlText: String) {
        COMMA(",", "<font color='" + Colors.RESERVED.hexCode + "'>,</font>"),
        VAR("var", "<font color='" + Colors.RESERVED.hexCode + "'>var</font>"),
        TRUE("true", "<font color='" + Colors.RESERVED.hexCode + "'>true</font>"),
        FALSE("false", "<font color='" + Colors.RESERVED.hexCode + "'>false</font>"),
        CONTINUE("continue", "<font color='" + Colors.RESERVED.hexCode + "'>continue</font>"),
        BREAK("break", "<font color='" + Colors.RESERVED.hexCode + "'>break</font>"),
        PRIVATE("private", "<font color='" + Colors.RESERVED.hexCode + "'>private</font>"),
        FOR("for", "<font color='" + Colors.RESERVED.hexCode + "'>for</font>"),
        WHILE("while", "<font color='" + Colors.RESERVED.hexCode + "'>while</font>"),
        IF("if", "<font color='" + Colors.RESERVED.hexCode + "'>if</font>"),
        ELSE("else", "<font color='" + Colors.RESERVED.hexCode + "'>else</font>"),
        ARRAY("Array", "<font color='" + Colors.RESERVED.hexCode + "'>array</font>")
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
        colorizeNumbers()
        colorizeAllStrings()
        colorizedString = colorizedString
            .replace(Reserved.PRIVATE.text, Reserved.PRIVATE.htmlText)
            .replace(Reserved.COMMA.text, Reserved.COMMA.htmlText)
            .replace(Reserved.TRUE.text, Reserved.TRUE.htmlText)
            .replace(Reserved.FALSE.text, Reserved.FALSE.htmlText)
            .replace(Reserved.BREAK.text, Reserved.BREAK.htmlText)
            .replace(Reserved.CONTINUE.text, Reserved.CONTINUE.htmlText)
            .replace(Reserved.VAR.text, Reserved.VAR.htmlText)
            .replace(Reserved.FOR.text, Reserved.FOR.htmlText)
            .replace(Reserved.IF.text, Reserved.IF.htmlText)
            .replace(Reserved.WHILE.text, Reserved.WHILE.htmlText)
            .replace(Reserved.ELSE.text, Reserved.ELSE.htmlText)
    }

    private fun colorizeAllChars() {
        val charSingleQuote = '\''
        var i = 0
        while (i < colorizedString.length) {
            val char = colorizedString[i]
            if (char == charSingleQuote) {
                val toBeReplaced = colorizedString.substring(i, i + 3)
                val colorizedReplacement = getColorizedStringOrChar(toBeReplaced, Colors.STRINGS_CHARS)
                colorizedString = colorizedString.replaceRange(i, i + 3, colorizedReplacement)
                i += (3 + colorizedReplacement.length)
                continue
            }
            i +=1
        }
    }


    private fun colorizeAllStrings() {
        val charDoubleQuote = '\"'
        var startPosition = -1
        var startHasBeenSet = false
        var i = 0
        while (i < colorizedString.length) {
            val char = colorizedString[i]
            if (char == charDoubleQuote) {
                if (startHasBeenSet) {
                    val toBeReplaced = colorizedString.substring(startPosition, i + 1)
                    val colorizedReplacement = getColorizedStringOrChar(toBeReplaced, Colors.STRINGS_CHARS)
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

    private fun colorizeNumbers() {
        var i = 0
        while (i < colorizedString.length) {
            var startIndex: Int
            var endIndex: Int
            val charAtI = colorizedString[i]
            if (charAtI.isDigit()) {
                startIndex = i
                endIndex = i + 1
                while (colorizedString[endIndex].isDigit() or (colorizedString[endIndex] == '.')) {
                    endIndex++
                }
                val replacement = getColorizedStringOrChar(colorizedString.substring(startIndex, endIndex), Colors.NUMBERS)
                colorizedString = colorizedString.replaceRange(startIndex, endIndex, replacement)
                i += (replacement.length + 1)
                continue
            }
            i++
        }
    }

    private fun getColorizedStringOrChar(sourceString: String, color:Colors): String {
        return "<font color='" + color.hexCode + "'>" + sourceString + "</font>"
    }

    internal fun getColorizedText(): String {
        return colorizedString
    }
}