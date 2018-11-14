package com.maxm.sorts.utils

import android.support.annotation.NonNull
import android.text.Html
import com.maxm.sorts.views.FontFlexTextView
import android.os.Build
import android.text.Spanned



class TextColorizer(@NonNull private val sourceString: String, @NonNull private val fontFlexTextView: FontFlexTextView) {

    enum class Colors(val color: String) {
        KEY_WORDS("#FF6600"),
        VALS_VARS("#00FFB9"),
        CHARS("#42FF00")
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

    private fun colorizeAndReplace() {
        /**colorizedString = sourceString.replace(ReservedWords.VAR.text, ReservedWords.VAR.htmlText)
        colorizedString = sourceString.replace(ReservedWords.VAL.text, ReservedWords.VAL.htmlText)
        colorizedString = sourceString.replace(ReservedWords.FOR.text, ReservedWords.FOR.htmlText)
        colorizedString = sourceString.replace(ReservedWords.IF.text, ReservedWords.IF.htmlText)
        colorizedString = sourceString.replace(ReservedWords.ARRAY.text, ReservedWords.ARRAY.htmlText)
        colorizedString = sourceString.replace(ReservedWords.WHILE.text, ReservedWords.WHILE.htmlText)
        colorizedString = sourceString.replace(ReservedWords.ELSE.text, ReservedWords.ELSE.htmlText) */
        val colorizedString = sourceString
            .replace(ReservedWords.VAR.text, ReservedWords.VAR.htmlText)
            .replace(ReservedWords.VAL.text, ReservedWords.VAL.htmlText)
            .replace(ReservedWords.FOR.text, ReservedWords.FOR.htmlText)
            .replace(ReservedWords.IF.text, ReservedWords.IF.htmlText)
            .replace(ReservedWords.WHILE.text, ReservedWords.WHILE.htmlText)
            .replace(ReservedWords.ELSE.text, ReservedWords.ELSE.htmlText)
        fontFlexTextView.text = fromHtml(colorizedString)
    }


    @Suppress("DEPRECATION")
    private fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }

}