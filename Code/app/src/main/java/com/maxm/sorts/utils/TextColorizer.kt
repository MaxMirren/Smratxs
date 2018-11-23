package com.maxm.sorts.utils

import android.support.annotation.NonNull

internal class TextColorizer(@NonNull private val sourceString: String) {

    private lateinit var colorizedString: String

    enum class Colors(val hexCode: String) {
        RESERVED("#FF6600"),
        NUMBERS("#00FFB9"),
        STRINGS_CHARS("#42FF00")
    }

    enum class Reserved(val text: String, val htmlText: String) {
        COMMA(",", "<font color='" + Colors.RESERVED.hexCode + "'>,</font>"),
        //SEMICOLON(";", "<font color='" + Colors.KEY_WORDS.hexCode + "'>;</font>"),
        VAR("var", "<font color='" + Colors.RESERVED.hexCode + "'>var</font>"),
        VAL("val", "<font color='" + Colors.RESERVED.hexCode + "'>val</font>"),
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
            .replace(Reserved.COMMA.text, Reserved.COMMA.htmlText)
            .replace(Reserved.VAR.text, Reserved.VAR.htmlText)
            .replace(Reserved.VAL.text, Reserved.VAL.htmlText)
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
            val charAtI = colorizedString[i]
            if (charAtI.isDigit()) {
                val replacement = getColorizedStringOrChar(charAtI.toString(), Colors.NUMBERS)
                colorizedString = colorizedString.replaceRange(i, i + 1, replacement)
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