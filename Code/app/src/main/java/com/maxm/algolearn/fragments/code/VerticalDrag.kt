package com.maxm.algolearn.fragments.code

import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.ScrollView
import androidx.appcompat.widget.Toolbar

/**
 * This class implements OnTouchListener to define view's behaviour
 * in a way of drag and drop in specified coordinates frame
 * [topStub and bottomStub - 5px]
 */
class VerticalDrag(private val parentLayout: ViewGroup,
                   private val scrollView: ScrollView?,
                   private val topStub: Int,
                   private val bottomStub: Int,
                   private val eachCardsHeight: Int,
                   private val toolbar: Toolbar
): View.OnTouchListener {

    // Stores the difference between first y event coordinate value and topMargin value of view
    private var _yDelta: Int = 0

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val y = event!!.rawY.toInt()
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                val lParams = v!!.layoutParams as RelativeLayout.LayoutParams
                _yDelta = y - lParams.topMargin
                scrollView?.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_UP -> {}
            MotionEvent.ACTION_POINTER_DOWN -> {}
            MotionEvent.ACTION_POINTER_UP -> {}
            MotionEvent.ACTION_MOVE -> {
                val layoutParams = v!!.layoutParams as RelativeLayout.LayoutParams
                val viewTopMargin = y - _yDelta
                if (viewTopMargin in topStub..(bottomStub - 5)) {
                    layoutParams.topMargin = viewTopMargin
                }
                v.layoutParams = layoutParams
            }
        }
        parentLayout.invalidate()
        return true
    }
}

