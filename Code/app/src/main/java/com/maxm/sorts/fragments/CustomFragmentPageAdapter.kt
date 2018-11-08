package com.maxm.sorts.fragments

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*

class CustomFragmentPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private lateinit var fragmentList: ArrayList<AbstractFragment>

    override fun getItem(p0: Int): AbstractFragment {
        return fragmentList[p0]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    internal fun setFragmentList(fragmentList: ArrayList<AbstractFragment>) {
        this.fragmentList = fragmentList
    }
}