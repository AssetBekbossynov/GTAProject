package com.example.user.gtaproject

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var pagerAdapter: FragmentStatePagerAdapter

    lateinit var fragment: Fragment
    lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")

        val adRequest = AdRequest.Builder().build()
        adBanner.loadAd(adRequest)


        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar!!.title = "Some Title"

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
                fragment = GTAVFragment()
            }
            R.id.gta_iv_ballad -> {
                fragment = GTAIVBalladFragment()
            }
            R.id.gta_iv_damned -> {
                fragment = GTAIVDamnedFragment()
            }
            R.id.gta_iv -> {
                fragment = GTAIVFragment()
            }
            R.id.gta_san_andreas -> {
                fragment = GTASAFragment()
            }
            R.id.gta_vice_city -> {
                fragment = GTAVCFragment()
            }
            R.id.gta_iii -> {
                fragment = GTAIIIFragment()
            }
            R.id.gta_2 -> {
                fragment = GTAIIFragment()
            }
            R.id.gta -> {
                fragment = GTAFragment()
            }
        }

        replaceFragment()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun replaceFragment(){
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }
}
