package com.maxm.algolearn.fragments

import android.widget.ImageView
import com.maxm.algolearn.R
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.views.custom.Font
import com.maxm.algolearn.views.custom.FontFlexTextView
import com.maxm.algolearn.views.custom.JustifiedFontFlexTextView


internal class FragmentAlgorithmDescription: AbstractFragment() {

    override val layoutResInt: Int =  R.layout.fragment_algorithm_description
    private lateinit var fontFlexTextViewAlgorithmDescTitle: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmDesc: JustifiedFontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmCharTitle: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmChar: JustifiedFontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmDemoTitle: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmDemo: ImageView


    override fun initialize() {
        setTextViewsParameters()
    }

    private fun setTextViewsParameters() {
        fontFlexTextViewAlgorithmDescTitle = thisObject.findViewById(R.id.f_desc_v_txt_description_title_desc)
        fontFlexTextViewAlgorithmDesc = thisObject.findViewById(R.id.f_desc_v_txt_description)
        fontFlexTextViewAlgorithmCharTitle = thisObject.findViewById(R.id.f_desc_v_txt_description_title_characteristics)
        fontFlexTextViewAlgorithmChar = thisObject.findViewById(R.id.f_desc_v_txt_characteristics)
        fontFlexTextViewAlgorithmDemoTitle = thisObject.findViewById(R.id.f_desc_v_txt_description_title_demo)
        fontFlexTextViewAlgorithmDemo = thisObject.findViewById(R.id.f_desc_v_img_demo)
        fontFlexTextViewAlgorithmDescTitle.setFont(Font.RUBIK_MEDIUM)
        fontFlexTextViewAlgorithmCharTitle.setFont(Font.RUBIK_MEDIUM)
        fontFlexTextViewAlgorithmDemoTitle.setFont(Font.RUBIK_MEDIUM)
        val algorithmDescription = Algorithm.List.getStringFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DESCRIPTION)
        setContent(algorithmDescription)
    }

    fun setContent(algorithmDescription: String) {
        fontFlexTextViewAlgorithmDesc.text = algorithmDescription
    }
}
