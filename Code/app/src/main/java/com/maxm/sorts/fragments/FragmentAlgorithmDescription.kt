package com.maxm.sorts.fragments
import com.maxm.sorts.R
import com.maxm.sorts.data.AlgorithmsListCreator
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView
import com.maxm.sorts.views.JustifiedTextView


class FragmentAlgorithmDescription: AbstractFragment() {

    override val layoutResInt: Int =  R.layout.fragment_algorithm_description

    override fun initialize() {
        val textViewAlgorithmName: FontFlexTextView = thisObject.findViewById(R.id.f_desc_txt_algorithm_name)
        textViewAlgorithmName.setFont(activity!!.assets, Font.SEGOEUI_SEMI_BOLD)
        val textViewAlgorithmDesc: JustifiedTextView = thisObject.findViewById(R.id.f_desc_txt_algorithm_desc)
        textViewAlgorithmDesc.setFont(activity!!.assets, Font.SEGOEUI_LIGHT)


        textViewAlgorithmName.text = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        textViewAlgorithmDesc.text = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DESCRIPTION)
    }
}
