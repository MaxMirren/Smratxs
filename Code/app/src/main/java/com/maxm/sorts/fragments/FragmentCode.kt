package com.maxm.sorts.fragments

import android.util.Log
import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.utils.TextToJavaCodeTransformer
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView
import android.text.Layout
import android.view.ViewTreeObserver.OnGlobalLayoutListener





internal class FragmentCode : AbstractFragment() {

    override val layoutResInt: Int = R.layout.fragment_fragment_code
    private lateinit var textViewAlgorithmName: FontFlexTextView
    private lateinit var textViewCode: FontFlexTextView
    private lateinit var textViewCodeLayout: Layout
    private lateinit var textViewDebugger: FontFlexTextView

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
        val algorithmName = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        val algorithmCode = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.CODE)
        val algorithmDebugger = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DEBUGGER)
        setContent(algorithmName, algorithmCode, algorithmDebugger)
    }

    fun setContent(algorithmName: String, algorithmCode: String, algorithmDebugger: String) {
        textViewAlgorithmName.text = algorithmName
        textViewCode.text = algorithmCode
        textViewDebugger.text = algorithmDebugger
        //observeTextViewCode()
        //Log.i("lines", textViewCodeLayout.lineCount.toString())
        TextToJavaCodeTransformer(algorithmCode, textViewCode)
        TextToJavaCodeTransformer(algorithmDebugger, textViewDebugger)
    }

    private fun observeTextViewCode() {
        val vto = textViewCode.viewTreeObserver
        vto.addOnPreDrawListener {
            textViewCodeLayout = textViewCode.layout
            true}
        textViewCode.onPreDraw()
        vto.removeOnPreDrawListener{
            textViewCodeLayout = textViewCode.layout
            false}
    }

}
