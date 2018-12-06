package com.maxm.sorts.fragments
import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView
import com.maxm.sorts.views.JustifiedFontFlexTextView


internal class FragmentAlgorithmDescription: AbstractFragment() {

    override val layoutResInt: Int =  R.layout.fragment_algorithm_description
    private lateinit var textViewAlgorithmName: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmDesc: JustifiedFontFlexTextView


    override fun initialize() {
        setTextViewsParameters()
    }

    private fun setTextViewsParameters() {
        textViewAlgorithmName = thisObject.findViewById(R.id.f_desc_txt_algorithm_name)
        textViewAlgorithmName.setFont(activity!!.assets, Font.SEGOEUI_SEMI_BOLD)
        fontFlexTextViewAlgorithmDesc = thisObject.findViewById(R.id.f_desc_txt_algorithm_desc)
        fontFlexTextViewAlgorithmDesc.setFont(activity!!.assets, Font.SEGOEUI_LIGHT)
        val algorithmName = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        val algorithmDescription = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DESCRIPTION)
        setContent(algorithmName, algorithmDescription)
    }

    fun setContent(algorithmName: String, algorithmDescription: String) {
        textViewAlgorithmName.text = algorithmName
        fontFlexTextViewAlgorithmDesc.text = algorithmDescription
    }
}
