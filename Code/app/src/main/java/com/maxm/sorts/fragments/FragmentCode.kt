package com.maxm.sorts.fragments

import android.os.Build
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.CardView
import android.text.Html
import android.text.Spanned
import android.util.DisplayMetrics
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.Toast
import com.maxm.sorts.R
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.data.sortsCode
import com.maxm.sorts.views.Font
import com.maxm.sorts.views.FontFlexTextView
import com.maxm.sorts.utils.TextColorizer
import com.maxm.sorts.utils.VerticalDrag

internal class FragmentCode : AbstractFragment() {

    // Links to fragment_fragment_code layout
    override val layoutResInt: Int = R.layout.fragment_fragment_code
    // Links to f_code_txt_algorithm_name Font Flex Text View
    private lateinit var textViewAlgorithmName: FontFlexTextView
    // Links to f_code_txt_code Font Flex Text View
    private lateinit var textViewCode: FontFlexTextView
    // Links to f_code_txt_debugger Font Flex Text View
    private lateinit var textViewDebugger: FontFlexTextView
    // Links to f_code_txt_code_numbering Font Flex Text View
    private lateinit var textViewLineCodeNumbered: FontFlexTextView
    // Links to f_code_card_code Card View
    private lateinit var cardCode: CardView
    // Links to f_code_fab_resize Floating Action Button
    private lateinit var fabResize: FloatingActionButton
    // Links to f_code_card_debug Card View
    private lateinit var cardDebug: CardView

    /**
     * Initializes fragment views data and behaviour
     */
    override fun initialize() {
        connectVarsToViews()
        setTextViewsParameters()
        setProperHeightsForCards()
    }

    /**
     * Connects vars to views placed in fragment fragment_fragment_code
     */
    private fun connectVarsToViews() {
        textViewAlgorithmName = thisObject.findViewById(R.id.f_code_txt_algorithm_name)
        textViewCode = thisObject.findViewById(R.id.f_code_txt_code)
        textViewDebugger = thisObject.findViewById(R.id.f_code_txt_debugger)
        textViewLineCodeNumbered = thisObject.findViewById(R.id.f_code_txt_code_numbering)
        fabResize = thisObject.findViewById(R.id.f_code_fab_resize)
        cardCode = thisObject.findViewById(R.id.f_code_card_code)
        cardDebug = thisObject.findViewById(R.id.f_code_card_debug)
    }

    /**
     * Sets fonts and text for all FontFlexTextView views
     */
    private fun setTextViewsParameters() {
        textViewAlgorithmName.setFont(activity!!.assets, Font.SEGOEUI_SEMI_BOLD)
        textViewCode.setFont(activity!!.assets, Font.LUCIDA_CONSOLE)
        textViewDebugger.setFont(activity!!.assets, Font.SEGOEUI_REGULAR)
        textViewLineCodeNumbered.setFont(activity!!.assets, Font.LUCIDA_CONSOLE)
        val algorithmName = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.NAME)
        val algorithmDebugger = Algorithm.List.getFieldOfAlgorithmWithIndex(0, Algorithm.List.Fields.DEBUGGER)
        setContent(algorithmName, algorithmDebugger)
    }

    /**
     * Sets data (text) for all FontFlexTextView views
     * @param algorithmName - name of algorithm which code is to be displayed and set to f_code_txt_algorithm_name
     * @param algorithmDebugger - debug data (text) which is to be set to textViewDebugger
     */
    fun setContent(algorithmName: String, algorithmDebugger: String) {
        textViewAlgorithmName.text = algorithmName
        textViewCode.text = fromHtml(sortsCode.getValue(algorithmName))
        textViewDebugger.text = fromHtml(TextColorizer(algorithmDebugger).getColorizedText())
        textViewLineCodeNumbered.useAsLineNumberingForFontTextView(textViewCode)
        setProperHeightsForCards()
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

    /**
     * Calculates the proper y position for f_code_fab_resize (cards are dependent on f_code_fab_resize position)
     * and behaviour
     * Calculates the best height for cards to fit the user's screen height
     */
    private fun setProperHeightsForCards() {
        thisObject.post {
            val fragmentHeight = thisObject.measuredHeight
            val dpSpaceInPx = convertDpToPixel(63f)
            val eachCardsHeight = ((fragmentHeight - dpSpaceInPx) / 2).toInt()
            val maxCodeCardHeightInPx = textViewLineCodeNumbered.layoutHeight
            val threeCodeLinesHeightInPx = (textViewLineCodeNumbered.layoutLineHeight * 3.2).toInt()
            val topYOfCodeCardView = cardCode.y.toInt()
            val layoutParams = fabResize.layoutParams as RelativeLayout.LayoutParams
            layoutParams.topMargin = convertDpToPixel(54f).toInt() + eachCardsHeight
            fabResize.layoutParams = layoutParams
            cardDebug.layoutParams.height = eachCardsHeight
            val resizeFabTopStub = topYOfCodeCardView + threeCodeLinesHeightInPx
            val resizeFabBottomStub = if (eachCardsHeight > maxCodeCardHeightInPx) {
                topYOfCodeCardView + eachCardsHeight
            }
            else {
                topYOfCodeCardView + maxCodeCardHeightInPx
            }
            setFabResizeBehaviour(resizeFabTopStub, resizeFabBottomStub)
        }
    }

    /**
     * Converts dp to px
     * @param dp dp value to be converted to px value in float
     * @return Float value of converted px
     */
    private fun convertDpToPixel(dp: Float): Float {
        val metrics = context!!.resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    /**
     * Sets f_code_fab_resize behaviour with onTouchListener
     */
    private fun setFabResizeBehaviour(topStub: Int, bottomStub: Int) {
        fabResize.setOnClickListener {
            Toast.makeText(
                this@FragmentCode.context, resources.getText(R.string.f_code_fab_resize_onclick),
                Toast.LENGTH_SHORT
            ).show()
        }
        val scrollView: ScrollView = thisObject.findViewById(R.id.f_code_scroll_v)
        val relativeLayout: RelativeLayout = thisObject.findViewById(R.id.f_code_lyt_constraint)
        fabResize.setOnTouchListener(VerticalDrag(relativeLayout, scrollView, topStub, bottomStub))
    }
}
