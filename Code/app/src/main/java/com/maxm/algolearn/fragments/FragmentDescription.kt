package com.maxm.algolearn.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maxm.algolearn.R
import com.maxm.algolearn.databinding.FragmentAlgorithmDescriptionBinding
import com.maxm.algolearn.viewmodels.FDescriptionViewModel
import com.maxm.algolearn.views.custom.Font
import com.maxm.algolearn.views.custom.FontFlexTextView
import com.maxm.algolearn.views.custom.JustifiedFontFlexTextView


internal class FragmentDescription: Fragment() {

    private lateinit var fontFlexTextViewAlgorithmDescTitle: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmDesc: JustifiedFontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmCharTitle: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmChar: FontFlexTextView
    private lateinit var fontFlexTextViewAlgorithmDemoTitle: FontFlexTextView
    private lateinit var thisObject: View
    private lateinit var binding: FragmentAlgorithmDescriptionBinding
    internal lateinit var viewModel: FDescriptionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_algorithm_description, container, false)
        thisObject = binding.root
        viewModel = FDescriptionViewModel()
        binding.fDescriptionViewModel = viewModel
        initialize()
        return thisObject
    }

    private fun initialize() {
        setTextViewsParameters()
    }

    private fun setTextViewsParameters() {
        fontFlexTextViewAlgorithmDescTitle = thisObject.findViewById(R.id.f_desc_v_txt_description_title_desc)
        fontFlexTextViewAlgorithmDesc = thisObject.findViewById(R.id.f_desc_v_txt_description)
        fontFlexTextViewAlgorithmCharTitle = thisObject.findViewById(R.id.f_desc_v_txt_description_title_characteristics)
        fontFlexTextViewAlgorithmChar = thisObject.findViewById(R.id.f_desc_v_txt_characteristics)
        fontFlexTextViewAlgorithmDemoTitle = thisObject.findViewById(R.id.f_desc_v_txt_description_title_demo)
        fontFlexTextViewAlgorithmDescTitle.setFont(Font.RUBIK_MEDIUM)
        fontFlexTextViewAlgorithmCharTitle.setFont(Font.RUBIK_MEDIUM)
        fontFlexTextViewAlgorithmDemoTitle.setFont(Font.RUBIK_MEDIUM)
        viewModel.setDefaultDescriptionData()
    }
}
