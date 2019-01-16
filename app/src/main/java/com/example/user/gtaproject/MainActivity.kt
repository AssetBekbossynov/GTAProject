package com.example.user.gtaproject

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var pagerAdapter: FragmentStatePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar!!.title = "Some Title"

        pagerAdapter = ContentAdapter(supportFragmentManager)
        view_pager.adapter = pagerAdapter
        tabs.setupWithViewPager(view_pager)

        tabs.getTabAt(0)!!.text = "PC"
        tabs.getTabAt(1)!!.text = "XBOX"
        tabs.getTabAt(2)!!.text = "PLAYSTATION"
        tabs.getTabAt(0)!!.icon = resources.getDrawable(R.drawable.pc)
        tabs.getTabAt(1)!!.icon = resources.getDrawable(R.drawable.xbox)
        tabs.getTabAt(2)!!.icon = resources.getDrawable(R.drawable.playstation)


//        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
//            override fun onTabReselected(p0: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabUnselected(p0: TabLayout.Tab?) {
//            }
//
//            override fun onTabSelected(p0: TabLayout.Tab?) {
//                when(p0!!.position){
//                    0->view_pager.currentItem = 0
//                    1->view_pager.currentItem = 1
//                    2->view_pager.currentItem = 2
//                }
//            }
//
//        })

        view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
                if (p0 != 2) {
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                }
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                if (p0 == 0) {
                    tabs.getTabAt(0)!!.select()
                } else if (p0 == 1) {
                    tabs.getTabAt(1)!!.select()
                } else if (p0 == 2) {
                    tabs.getTabAt(2)!!.select()
                }
            }

        })

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.gta_v -> {
                Toast.makeText(this, "here", Toast.LENGTH_SHORT).show()
            }
            R.id.gta_iv_ballad -> {

            }
            R.id.gta_iv_damned -> {

            }
            R.id.gta_iv -> {

            }
            R.id.gta_san_andreas -> {

            }
            R.id.gta_vice_city -> {

            }
            R.id.gta_iii -> {

            }
            R.id.gta_2 -> {

            }
            R.id.gta -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
