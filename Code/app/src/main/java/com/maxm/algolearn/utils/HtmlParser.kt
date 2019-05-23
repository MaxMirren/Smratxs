package com.maxm.algolearn.utils

import android.os.Build
import android.text.Html
import android.text.Spanned

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