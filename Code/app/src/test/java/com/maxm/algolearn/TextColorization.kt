package com.maxm.algolearn

import org.junit.Assert
import org.junit.Test
import java.lang.Exception

class TextColorization {

    private var colorizedString: String = "System.out.println(\"Printing value\"), \'number\', 45. 32"
    // 3 symbols in string
    private var colorizedString1: String = "\"j\""

    private enum class Colors(val hexCode: String) {
        RESERVED("#FF6600"),
        NUMBERS("#00FFB9"),
        STRINGS_CHARS("#42FF00")
    }

    @Test
    fun colorizeText() {
        Assert.assertEquals(true, if (colorizedString.length < 3) {
            throw TooShortStringLengthException()
        } else {
            colorizeAllStrings()
            colorizeAllChars()
            colorizeNumbers()
            true
        })
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

    private fun getColorizedStringOrChar(sourceString: String, color: Colors): String {
        return "<font color='" + color.hexCode + "'>" + sourceString + "</font>"
    }
}

class TooShortStringLengthException: Exception() {
    init {
        System.err.println("Currently using string is tool short to be colorized")
    }
}
