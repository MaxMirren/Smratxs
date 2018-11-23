package com.maxm.sorts.fragments

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.data.sortsCode
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView
import com.maxm.sorts.utils.TextColorizer


internal class FragmentCode : AbstractFragment() {

    override val layoutResInt: Int = R.layout.fragment_fragment_code
    private lateinit var textViewAlgorithmName: FontFlexTextView
    private lateinit var textViewCode: FontFlexTextView
    private lateinit var textViewDebugger: FontFlexTextView
    private lateinit var lineCodeNumbered: FontFlexTextView

    override fun initialize() {
        setTextViewsParameters()
    }

    private fun setTextViewsParameters() {
        textViewAlgorithmName = thisObject.findViewById(R.id.f_code_txt_algorithm_name)
        textViewAlgorithmName.setFont(activity!!.assets, Font.SEGOEUI_SEMI_BOLD)
        textViewCode = thisObject.findViewById(R.id.f_code_txt_code)
        textViewCode.setFont(activity!!.assets, Font.LUCIDA_CONSOLE)
        textViewDebugger = thisObject.findViewById(R.id.f_code_txt_debugger)
        textViewDebugger.setFont(activity!!.assets, Font.SEGOEUI_REGULAR)
        lineCodeNumbered = thisObject.findViewById(R.id.f_code_txt_code_numbering)
        lineCodeNumbered.setFont(activity!!.assets, Font.LUCIDA_CONSOLE)
        val algorithmName = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        val algorithmDebugger = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DEBUGGER)
        setContent(algorithmName, algorithmDebugger)
    }

    fun setContent(algorithmName: String, algorithmDebugger: String) {
        textViewAlgorithmName.text = algorithmName
        textViewCode.text = fromHtml(sortsCode.getValue(algorithmName))
        textViewDebugger.text = fromHtml(TextColorizer(algorithmDebugger).getColorizedText())
        lineCodeNumbered.useAsLineNumberingForFontTextView(textViewCode)
    }

    /**
     * Gets spanned content from HTML in two ways in dependence on Android version
     * @param html is string data which is to be converted to spanned html data
     * @suppress using Html.fromHtml method for Android versions under Marshmallow
     */
    @Suppress("DEPRECATION")
    private fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }
}
