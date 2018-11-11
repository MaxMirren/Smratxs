package com.maxm.sorts

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageButton
import android.widget.Toast
import com.maxm.sorts.fragments.CustomFragmentPageAdapter
import com.maxm.sorts.fragments.FragmentAlgorithmDescription
import com.maxm.sorts.fragments.FragmentCode

/**
 * This class represents and implements the logic of main layout.activity_main
 * @author MaxMirren
 */
class ActivityMain : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var actionBarDrawerToggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    /**
     * Uses as menu to start up class init processes
     */
    private fun initialize() {
        initializeGloballyUsedViews()
        setViewPager()
        setFabBehaviour()
        setBottomNavigationView()
    }

    /**
     * Initializes globally used views - connects them to pre-declared lateinit variables
     */
    private fun initializeGloballyUsedViews() {
        viewPager = findViewById(R.id.a_m_view_pager)
    }

    /**
     * Sets view pager id.a_m_view_pager controls
     */
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

    /**
     * Sets floating action button id.desc_a_m_img_btn_go behaviour
     */
    private fun setFabBehaviour() {
        val fab: ImageButton = findViewById(R.id.desc_a_m_img_btn_go)
        fab.setOnClickListener {
            viewPager.currentItem = 1
        }
    }

    /**
     * Sets navigation drawer availability and content
     */
    private fun setBottomNavigationView() {
        val drawerLayout: DrawerLayout = findViewById(R.id.a_m_lyt_drl)
        val toolbar: Toolbar = findViewById(R.id.a_m_bottom_app_bar)
        setSupportActionBar(toolbar)
        actionBarDrawerToggle =
                ActionBarDrawerToggle(
                    this, drawerLayout, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close
                )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

}
