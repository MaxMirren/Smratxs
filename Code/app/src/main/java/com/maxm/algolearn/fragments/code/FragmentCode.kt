package com.maxm.algolearn.fragments.code

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.Toast
import com.maxm.algolearn.R
import com.maxm.algolearn.views.custom.Font
import com.maxm.algolearn.views.custom.FontFlexTextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.maxm.algolearn.databinding.FragmentCodeBinding
import com.maxm.algolearn.viewmodels.FCodeViewModel

class FragmentCode: Fragment() {

    // Current view model instance
    lateinit var viewModel: FCodeViewModel
    // Links to f_code_txt_code Font Flex Text View
    private lateinit var textViewCode: FontFlexTextView
    // Links to f_code_txt_debugger Font Flex Text View
    private lateinit var textViewDebugger: FontFlexTextView
    // Links to f_code_txt_code_numbering Font Flex Text View
    private lateinit var textViewLineCodeNumbered: FontFlexTextView
    // Links to f_code_card_code Card View
    private lateinit var cardCode: androidx.cardview.widget.CardView
    // Links to f_code_fab_resize Floating Action Button
    private lateinit var fabResize: FloatingActionButton
    // Links to f_code_card_debug Card View
    private lateinit var cardDebug: androidx.cardview.widget.CardView
    // Links to ActivityMain Toolbar object
    private lateinit var mainToolbar: Toolbar
    // Binding link
    private lateinit var binding: FragmentCodeBinding
    // Stores the link of current object to be used as this
    private lateinit var thisObject: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_code, container, false)
        thisObject = binding.root
        viewModel = FCodeViewModel()
        binding.fCodeViewModel = viewModel
        initialize()
        return thisObject
    }

    /**
     * Initializes fragment views data and behaviour
     */
    private fun initialize() {
        connectVarsToViews()
        setTextViewsParameters()
        setProperHeightsForCards()
    }

    /**
     * Initializes mainToolbar global var with link to ActivityMain WhiteGreyAccentToolbar object
     */
    internal fun setMainToolbar(toolbar: Toolbar) {
        mainToolbar = toolbar
    }

    /**
     * Connects vars to views placed in fragment fragment_code
     */
    private fun connectVarsToViews() {
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
        viewModel.setDefaultAlgorithmContent()
        textViewCode.setFont(Font.LUCIDA_CONSOLE)
        textViewDebugger.setFont(Font.SEGOEUI_REGULAR)
        textViewLineCodeNumbered.setFont(Font.LUCIDA_CONSOLE)
        textViewLineCodeNumbered.useAsLineNumberingForFontTextView(textViewCode)
    }

    /**
     * Calculates the proper y position for f_code_fab_resize (cards are dependent on f_code_fab_resize position)
     * and behaviour
     * Calculates the best height for cards to fit the user's screen height
     */
    fun setProperHeightsForCards() {
        thisObject.post {
            val fragmentHeight = thisObject.measuredHeight
            val dpSpaceInPx = convertDpToPixel(63f)
            val eachCardsHeight = ((fragmentHeight - dpSpaceInPx) / 2).toInt()
            val maxCodeCardHeightInPx = textViewLineCodeNumbered.layoutHeight
            val lineHeightInPx = textViewLineCodeNumbered.layoutLineHeight
            val threeCodeLinesHeightInPx = (lineHeightInPx * 3.2).toInt()
            val topYOfCodeCardView = cardCode.y.toInt()
            val layoutParams = fabResize.layoutParams as RelativeLayout.LayoutParams
            layoutParams.topMargin = convertDpToPixel(54f).toInt() + eachCardsHeight
            fabResize.layoutParams = layoutParams
            cardDebug.layoutParams.height = eachCardsHeight
            val resizeFabTopStub = topYOfCodeCardView + threeCodeLinesHeightInPx
            val resizeFabBottomStub = if (eachCardsHeight > maxCodeCardHeightInPx) {
                topYOfCodeCardView + eachCardsHeight - (lineHeightInPx * 0.7).toInt()
            }
            else {
                topYOfCodeCardView + maxCodeCardHeightInPx + lineHeightInPx
            }
            setFabResizeBehaviour(resizeFabTopStub, resizeFabBottomStub, eachCardsHeight)
        }
    }

    /**
     * Sets f_code_fab_resize behaviour with onTouchListener
     * @param topStub - top stub for movement and resizing
     * @param bottomStub - bottom stub for movement and resizing
     */
    private fun setFabResizeBehaviour(topStub: Int, bottomStub: Int, eachCardsHeight: Int) {
        fabResize.setOnClickListener {
            Toast.makeText(
                this@FragmentCode.context, resources.getText(R.string.f_code_fab_resize_onclick),
                Toast.LENGTH_SHORT
            ).show()
        }
        val scrollView: ScrollView = thisObject.findViewById(R.id.f_code_scroll_v)
        val relativeLayout: RelativeLayout = thisObject.findViewById(R.id.f_code_lyt_constraint)
        fabResize.setOnTouchListener(
            VerticalDrag(
                relativeLayout,
                scrollView,
                topStub,
                bottomStub,
                eachCardsHeight,
                mainToolbar
            )
        )
    }

    /**
     * Converts dp to px
     * @param dp dp value to be converted to px value in float
     * @return Float value of converted px
     */
    private fun convertDpToPixel(dp: Float): Float {
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }
}
