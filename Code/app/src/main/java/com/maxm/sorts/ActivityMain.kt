package com.maxm.sorts

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.maxm.sorts.fragments.CustomFragmentPageAdapter
import com.maxm.sorts.fragments.FragmentAlgorithmDescription
import com.maxm.sorts.fragments.FragmentCode


class ActivityMain : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        initializeGloballyUsedViews()
        setViewPager()
        setFabBehaviour()
    }

    private fun initializeGloballyUsedViews() {
        viewPager = findViewById(R.id.view_pager)
    }

    private fun setViewPager() {
        val customFragmentPageAdapter = CustomFragmentPageAdapter(supportFragmentManager!!)
        customFragmentPageAdapter.setFragmentList(arrayListOf(FragmentAlgorithmDescription(), FragmentCode()))
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                Toast.makeText(this@ActivityMain, "onPageSelected called", Toast.LENGTH_LONG).show()
            }

        })
        viewPager.adapter = customFragmentPageAdapter
        viewPager.currentItem = 0
    }

    private fun setFabBehaviour() {
        val fab: FloatingActionButton = findViewById(R.id.fab1)
        fab.setOnClickListener {
            viewPager.currentItem = 1
        }
    }
}
