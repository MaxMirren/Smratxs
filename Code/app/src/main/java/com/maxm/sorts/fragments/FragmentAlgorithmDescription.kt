package com.maxm.sorts.fragments
import com.maxm.sorts.R
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.JustifiedTextView


class FragmentAlgorithmDescription: AbstractFragment() {

    override val layoutResInt: Int =  R.layout.fragment_algorithm_description

    override fun initialize() {
        val textViewAlgorithmName: JustifiedTextView = thisObject.findViewById(R.id.v_txt_algorithm_name)
        textViewAlgorithmName.setFont(activity!!.assets, Font.SEGOEUI_SEMI_BOLD)
        val textViewAlgorithmDesc: JustifiedTextView = thisObject.findViewById(R.id.v_txt_algorithm_desc)
        textViewAlgorithmDesc.setFont(activity!!.assets, Font.SEGOEUI_LIGHT)
    }
}
