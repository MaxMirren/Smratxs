package com.maxm.sorts.views

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import com.maxm.sorts.R

internal class FontFlexTextView : TextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    // Indicates whether this object is used as line numbering FontTextView or not
    var isLineNumbering = false
    private set

    /**
     * Sets font for current object
     * @param assets used to get access to AssetManager from calling activity or fragment
     * @param fontType indicates font and its type to be set for this object
     */
    fun setFont(assets: AssetManager, fontType: Font) {
        val font = Typeface.createFromAsset(assets, fontType.font)
        this.typeface = font
    }


    /**
     * Makes it used as line numbering for another fontTextView
     * @param fontFlexTextView is used to get its layout lines count to set proper numbering for this object
     * @throws InappropriateStyleException throws if  this object style has not been set to SortsTextViewCodeNumbering
     */
    fun useAsLineNumberingForFontTextView(fontFlexTextView: FontFlexTextView) {
        val vto = fontFlexTextView.viewTreeObserver
        vto.addOnGlobalLayoutListener{
            val lines = fontFlexTextView.layout.lineCount
            this@FontFlexTextView.text = ""
            if (this@FontFlexTextView.thisColorIsShadow()) {
                var data = ""
                for (n in 1..lines) {
                    data += n.toString()
                    if (n!= lines) {
                        data += "\n"
                    }
                }
                this@FontFlexTextView.isLineNumbering = true
                this@FontFlexTextView.text = data
            }
            else{
                throw InappropriateStyleException()
            }
        }
    }

    /**
     * Checks if current color is set to R.color.shadow
     * @return false if current color is NOT set to R.color.shadow
     * @suppress using resources.getColor method for Android versions under Marshmallow
     */
    @Suppress("DEPRECATION")
    private fun thisColorIsShadow(): Boolean {
        val neededColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            resources.getColor(R.color.shadow, null)
        }
        else {
            resources.getColor(R.color.shadow)
        }
        return currentTextColor == neededColor
    }
}