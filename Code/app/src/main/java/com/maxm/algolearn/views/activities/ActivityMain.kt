package com.maxm.algolearn.views.activities

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.maxm.algolearn.models.Algorithm
import com.maxm.algolearn.fragments.CustomFragmentPageAdapter
import com.maxm.algolearn.fragments.FragmentAlgorithmDescription
import com.maxm.algolearn.fragments.code.FragmentCode
import com.maxm.algolearn.R
import com.maxm.algolearn.activities.main.MainPresenter
import com.maxm.algolearn.views.custom.Font
import com.maxm.algolearn.views.custom.FontFlexTextView
import kotlin.system.exitProcess

/**
 * This class represents and implements the logic of main layout.activity_main
 * @author MaxMirren
 */
class ActivityMain : AppCompatActivity() {

    private lateinit var mainPresenter: MainPresenter
    private lateinit var viewPager: androidx.viewpager.widget.ViewPager
    private lateinit var actionBarDrawerToggle : ActionBarDrawerToggle
    private lateinit var fragmentAlgorithmDescription: FragmentAlgorithmDescription
    private lateinit var fragmentCode: FragmentCode
    private lateinit var bottomAppBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    override fun onBackPressed() {
        finish()
        exitProcess(0)
    }

    /**
     * Used to start up class init processes
     */
    private fun initialize() {
        initializeGloballyUsedViews()
        mainPresenter = MainPresenter(this)
        mainPresenter.initializeAlgorithmsList()
        setViewPager()
        setNavigationView()
        setFabBehaviour()
        setImgBtnShareBehaviour()
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
        val customFragmentPageAdapter = CustomFragmentPageAdapter(supportFragmentManager)
        fragmentAlgorithmDescription = FragmentAlgorithmDescription()
        fragmentCode = FragmentCode()
        bottomAppBar = this@ActivityMain.findViewById(R.id.a_m_bottom_app_bar)
        fragmentCode.setMainToolbar(bottomAppBar)
        findViewById<FontFlexTextView>(R.id.a_m_bab_v_txt_alg_name).setFont(Font.RUBIK_REGULAR)
        findViewById<FontFlexTextView>(R.id.a_m_bab_v_txt_grp_name).setFont(Font.RUBIK_MEDIUM)
        customFragmentPageAdapter.setFragmentList(arrayListOf(fragmentAlgorithmDescription, fragmentCode))
        viewPager.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                viewPager.currentItem = position

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
        mainPresenter.addAllItemsToNavigationView(navigationView)
        navigationView.setNavigationItemSelectedListener { it.run {
                val algorithmName = Algorithm.List.getStringFieldOfAlgorithmWithIndex(it.itemId, Algorithm.List.Fields.NAME)
                if (algorithmName.isNotEmpty()) {
                    val algorithmDescription =
                        Algorithm.List.getStringFieldOfAlgorithmWithIndex(it.itemId, Algorithm.List.Fields.DESCRIPTION)
                    val algorithmDebugger =
                        Algorithm.List.getStringFieldOfAlgorithmWithIndex(it.itemId, Algorithm.List.Fields.DEBUGGER)
                    fragmentAlgorithmDescription.setContent(algorithmDescription)
                    fragmentCode.setContent(algorithmName, algorithmDebugger)
                    val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = this@ActivityMain.findViewById(R.id.a_m_lyt_drl)
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                }
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
        val imgBtnCode: ImageButton = findViewById(R.id.a_m_bab_v_img_btn_share)
        imgBtnCode.setOnClickListener {
            Toast.makeText(this, "This function is not implemented yet", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Sets navigation drawer availability and content
     */
    private fun setBottomNavigationView() {
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.a_m_lyt_drl)
        val toolbar: Toolbar = findViewById(R.id.a_m_bottom_app_bar)
        setSupportActionBar(toolbar)
        actionBarDrawerToggle =
                ActionBarDrawerToggle (
                    this, drawerLayout, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close
                )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

}