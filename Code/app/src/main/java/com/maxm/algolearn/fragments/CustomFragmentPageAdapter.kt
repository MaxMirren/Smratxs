package com.maxm.algolearn.fragments

import java.util.*

internal class CustomFragmentPageAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

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