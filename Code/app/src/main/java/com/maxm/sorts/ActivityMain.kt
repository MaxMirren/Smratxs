package com.maxm.sorts

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.ImageButton
import android.widget.Toast
import com.maxm.sorts.data.Algorithm
import com.maxm.sorts.data.AlgorithmsListCreator
import com.maxm.sorts.data.sortsCode
import com.maxm.sorts.fragments.CustomFragmentPageAdapter
import com.maxm.sorts.fragments.FragmentAlgorithmDescription
import com.maxm.sorts.fragments.FragmentCode
import com.maxm.sorts.utils.TextColorizer

/**
 * This class represents and implements the logic of main layout.activity_main
 * @author MaxMirren
 */
internal class ActivityMain : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var actionBarDrawerToggle : ActionBarDrawerToggle
    private lateinit var fragmentAlgorithmDescription: FragmentAlgorithmDescription
    private lateinit var fragmentCode: FragmentCode

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
        initializeAlgorithmsList()
        setViewPager()
        setNavigationView()
        setFabBehaviour()
        setImgBtnShareBehaviour()
        setImgBtnCodeBehaviour()
        setBottomNavigationView()
    }

    /**
     * Initializes globally used views - connects them to pre-declared lateinit variables
     */
    private fun initializeGloballyUsedViews() {
        viewPager = findViewById(R.id.a_m_view_pager)
    }

    /**
     * Initializes list of algorithms places in strings.xml
     */
    private fun initializeAlgorithmsList() {
        val namesArray = resources.getStringArray(R.array.sorts_names)
        val descriptionArray = resources.getStringArray(R.array.sorts_description)
        val debuggerArray = resources.getStringArray(R.array.sorts_debugs)
        AlgorithmsListCreator(namesArray, descriptionArray, debuggerArray, R.string.category_0)
        for (key in sortsCode.keys) {
            sortsCode[key] = TextColorizer(sortsCode.getValue(key)).getColorizedText()
        }
    }

    /**
     * Sets view pager id.a_m_view_pager controls
     */
    private fun setViewPager() {
        val customFragmentPageAdapter = CustomFragmentPageAdapter(supportFragmentManager!!)
        fragmentAlgorithmDescription = FragmentAlgorithmDescription()
        fragmentCode = FragmentCode()
        customFragmentPageAdapter.setFragmentList(arrayListOf(fragmentAlgorithmDescription, fragmentCode))
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                val bottomAppBar: Toolbar = this@ActivityMain.findViewById(R.id.a_m_bottom_app_bar)
                if (position == 0) {
                    bottomAppBar.background =
                            this@ActivityMain.resources.getDrawable(R.drawable.main_bab_background_white, this@ActivityMain.theme)
                }
                else {
                    bottomAppBar.background =
                            this@ActivityMain.resources.getDrawable(R.drawable.main_bab_background_grey, this@ActivityMain.theme)
                }
            }

        })
        viewPager.adapter = customFragmentPageAdapter
        viewPager.currentItem = 0
    }

    /**
     * Sets navigation view with a_m_nav behaviour
     */
    private fun setNavigationView() {
        val navigationView: NavigationView = findViewById(R.id.a_m_nav)
        for (i in 0 until Algorithm.List.getAlgorithmsCount() - 1) {
            navigationView.menu.add(0, i, 0,
                Algorithm.List.getFieldOfAlgorithmWithIndex(i, Algorithm.List.Fields.NAME))
        }
        navigationView.setNavigationItemSelectedListener { it ->
            run {
                val algorithmName = Algorithm.List.getFieldOfAlgorithmWithIndex(it.itemId, Algorithm.List.Fields.NAME)
                val algorithmDescription =
                    Algorithm.List.getFieldOfAlgorithmWithIndex(it.itemId, Algorithm.List.Fields.DESCRIPTION)
                //val algorithmCode = sortsCode.getValue(algorithmName)
                val algorithmDebugger =
                    Algorithm.List.getFieldOfAlgorithmWithIndex(it.itemId, Algorithm.List.Fields.DEBUGGER)
                fragmentAlgorithmDescription.setContent(algorithmName, algorithmDescription)
                fragmentCode.setContent(algorithmName, algorithmDebugger)
                val drawerLayout: DrawerLayout = this@ActivityMain.findViewById(R.id.a_m_lyt_drl)
                drawerLayout.closeDrawer(Gravity.START)
            }
            false
        }
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
     * Sets ImgBtn Share (placed on bottom_app_bar.xml) behaviour
     */
    private fun setImgBtnShareBehaviour() {
        val imgBtnCode: ImageButton = findViewById(R.id.a_m_bab_img_btn_share)
        imgBtnCode.setOnClickListener {
            Toast.makeText(this, "This function is not implemented yet", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Sets ImgBtn Code (placed on bottom_app_bar.xml) behaviour
     */
    private fun setImgBtnCodeBehaviour() {
        val imgBtnCode: ImageButton = findViewById(R.id.a_m_bab_img_btn_code)
        imgBtnCode.setOnClickListener {viewPager.currentItem = 1}
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
