package com.maxm.sorts.fragments

import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.utils.TextColorizer
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView

class FragmentCode : AbstractFragment() {

    override val layoutResInt: Int = R.layout.fragment_fragment_code

    override fun initialize() {
        setTextViewsParameters()
    }

    private fun setTextViewsParameters() {
        val textViewAlgorithmName: FontFlexTextView = thisObject.findViewById(R.id.f_code_txt_algorithm_name)
        textViewAlgorithmName.setFont(activity!!.assets, Font.SEGOEUI_SEMI_BOLD)
        textViewAlgorithmName.text = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        val textViewCode: FontFlexTextView = thisObject.findViewById(R.id.f_code_txt_code)
        textViewCode.setFont(activity!!.assets, Font.LUCIDA_CONSOLE)
        TextColorizer(Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.CODE), textViewCode)
        val textViewDebugger: FontFlexTextView = thisObject.findViewById(R.id.f_code_txt_debugger)
        textViewDebugger.setFont(activity!!.assets, Font.SEGOEUI_REGULAR)
        TextColorizer(Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DEBUGGER), textViewDebugger)
    }




}
