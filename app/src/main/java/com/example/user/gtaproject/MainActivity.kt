package com.example.user.gtaproject

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.preference.PreferenceManager
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.crashlytics.android.Crashlytics
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import com.google.android.gms.ads.InterstitialAd
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.rate_dialog.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mInterstitialAd: InterstitialAd

    lateinit var gtavFragment: GTAVFragment
    lateinit var gtaivBalladFragment: GTAIVBalladFragment
    lateinit var gtaivDamnedFragment: GTAIVDamnedFragment
    lateinit var gtaivFragment: GTAIVFragment
    lateinit var gtasaFragment: GTASAFragment
    lateinit var gtavcFragment: GTAVCFragment
    lateinit var gtaiiiFragment: GTAIIIFragment
    lateinit var gtaiiFragment: GTAIIFragment
    lateinit var gtaFragment: GTAFragment
    lateinit var fragmentTransaction: FragmentTransaction

    lateinit var pref: SharedPreferences

    lateinit var dialog: Dialog

    val countDownTimer = object: CountDownTimer(30 * 1000, 1000) {
        override fun onFinish() {
            dialog.show()
        }

        override fun onTick(p0: Long) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fabric.with(this, Crashlytics())

        pref = PreferenceManager.getDefaultSharedPreferences(this)

        pref.edit().putInt("launchCount", pref.getInt("launchCount", 0) + 1).apply()

        if (!pref.getBoolean("dontShowAgain", false)){
            if (pref.getInt("launchCount", 0) > 3){
                countDownTimer.start()
                dialog = Dialog(this)
                val view = layoutInflater.inflate(R.layout.rate_dialog, null)
                dialog.setContentView(view)
                dialog.setCanceledOnTouchOutside(false)

                view.later.setOnClickListener {
                    pref.edit().putInt("launchCount", 0).apply()
                    dialog.dismiss()
                }

                view.rate.setOnClickListener {
                    try {
                        startActivity(Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + application.packageName)))
                    } catch (e: android.content.ActivityNotFoundException) {
                        startActivity(Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + application.packageName)))
                    }
                    pref.edit().putBoolean("dontShowAgain", true).apply()
                    dialog.dismiss()
                }

                view.no.setOnClickListener {
                    pref.edit().putBoolean("dontShowAgain", true).apply()
                    dialog.dismiss()
                }
            }
        }

        MobileAds.initialize(this, BuildConfig.AdMob_ID)

        mInterstitialAd = InterstitialAd(this)

        mInterstitialAd.setAdUnitId(BuildConfig.Intersitial_ID)

        val adRequest = AdRequest.Builder().build()
        mInterstitialAd.loadAd(adRequest)
        adBanner.loadAd(adRequest)

        gtavFragment = GTAVFragment()
        gtaivBalladFragment = GTAIVBalladFragment()
        gtaivDamnedFragment = GTAIVDamnedFragment()
        gtaivFragment = GTAIVFragment()
        gtasaFragment = GTASAFragment()
        gtavcFragment = GTAVCFragment()
        gtaiiiFragment = GTAIIIFragment()
        gtaiiFragment = GTAIIFragment()
        gtaFragment = GTAFragment()

        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, gtavFragment)
        fragmentTransaction.commitNow()

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar!!.title = getString(R.string.gtav_title)

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


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
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.gta_v -> {
                supportActionBar!!.title = getString(R.string.gtav_title)
                fragmentTransaction.replace(R.id.fragment, gtavFragment)
            }
            R.id.gta_iv_ballad -> {
                supportActionBar!!.title = getString(R.string.gtaiv_ballad_main_title)
                fragmentTransaction.replace(R.id.fragment, gtaivBalladFragment)
            }
            R.id.gta_iv_damned -> {
                supportActionBar!!.title = getString(R.string.gtaiv_lost_main_title)
                fragmentTransaction.replace(R.id.fragment, gtaivDamnedFragment)
            }
            R.id.gta_iv -> {
                supportActionBar!!.title = getString(R.string.gtaiv_main_title)
                fragmentTransaction.replace(R.id.fragment, gtaivFragment)
            }
            R.id.gta_san_andreas -> {
                supportActionBar!!.title = getString(R.string.gtasa_main_title)
                fragmentTransaction.replace(R.id.fragment, gtasaFragment)
            }
            R.id.gta_vice_city -> {
                supportActionBar!!.title = getString(R.string.gtavc_main_title)
                fragmentTransaction.replace(R.id.fragment, gtavcFragment)
            }
            R.id.gta_iii -> {
                supportActionBar!!.title = getString(R.string.gtaiii_main_title)
                fragmentTransaction.replace(R.id.fragment, gtaiiiFragment)
            }
            R.id.gta_2 -> {
                supportActionBar!!.title = getString(R.string.gtaii_main_title)
                fragmentTransaction.replace(R.id.fragment, gtaiiFragment)
            }
            R.id.gta -> {
                supportActionBar!!.title = getString(R.string.gta_main_title)
                fragmentTransaction.replace(R.id.fragment, gtaFragment)
            }
        }

        fragmentTransaction.commitNow()

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
