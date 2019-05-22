package com.maxm.algolearn.fragments

import androidx.fragment.app.Fragment
import java.util.*

internal class CustomFragmentPageAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

    private lateinit var fragmentList: ArrayList<Fragment>

    override fun getItem(p0: Int): Fragment {
        return fragmentList[p0]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    internal fun setFragmentList(fragmentList: ArrayList<Fragment>) {
        this.fragmentList = fragmentList
    }
}