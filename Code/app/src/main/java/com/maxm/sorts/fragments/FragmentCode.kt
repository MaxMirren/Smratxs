package com.maxm.sorts.fragments

import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView
import android.text.Layout
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
        val algorithmCode = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.CODE)
        val algorithmDebugger = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DEBUGGER)
        setContent(algorithmName, algorithmCode, algorithmDebugger)
    }

    fun setContent(algorithmName: String, algorithmCode: String, algorithmDebugger: String) {
        textViewAlgorithmName.text = algorithmName
        TextColorizer(algorithmCode, textViewCode)
        TextColorizer(algorithmDebugger, textViewDebugger)
        lineCodeNumbered.useAsLineNumberedForFontTextView(textViewCode)
    }

}
