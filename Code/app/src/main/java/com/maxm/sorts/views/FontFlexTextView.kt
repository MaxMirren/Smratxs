package com.maxm.sorts.views

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

import android.util.DisplayMetrics
import android.widget.Toast
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.ViewTreeObserver





internal class FontFlexTextView : TextView {
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

    fun useAsLineNumberedForFontTextView(fontFlexTextView: FontFlexTextView) {
        val textViewDpLineHeight =
            convertPixelsToDp(fontFlexTextView.lineHeight + fontFlexTextView.lineSpacingExtra.toInt())
        //var lines: = 3

        val vto = fontFlexTextView.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val lines = fontFlexTextView.layout.lineCount
                this@FontFlexTextView.text = ""
                var data = ""
                for (n in 1..lines) {
                    data += n.toString()
                    if (n!= lines) {
                        data += "\n"
                    }
                }
                this@FontFlexTextView.text = data
            }
        })

        /*this.text = ""
        var data = ""
        for (n in 1..lines) {
            data += n.toString()
            if (n!= lines) {
                data += "\n"
            }
        }
        this.text = data */
    }



    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    private fun convertPixelsToDp(px: Int): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}