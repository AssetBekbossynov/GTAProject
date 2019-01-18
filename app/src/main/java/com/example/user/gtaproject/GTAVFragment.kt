package com.example.user.gtaproject

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.gtav_fragment.view.*

class GTAVFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.gtav_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = ContentAdapter(childFragmentManager)
        view.view_pager.adapter = pagerAdapter
        view.tabs.setupWithViewPager(view.view_pager)

        view.view_pager.offscreenPageLimit = 2

        view.tabs.getTabAt(0)!!.text = "PC"
        view.tabs.getTabAt(1)!!.text = "XBOX"
        view.tabs.getTabAt(2)!!.text = "PLAYSTATION"
        view.tabs.getTabAt(0)!!.icon = resources.getDrawable(R.drawable.pc)
        view.tabs.getTabAt(1)!!.icon = resources.getDrawable(R.drawable.xbox)
        view.tabs.getTabAt(2)!!.icon = resources.getDrawable(R.drawable.playstation)

        view.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                when(p0!!.position){
                    0->view.view_pager.currentItem = 0
                    1->view.view_pager.currentItem = 1
                    2->view.view_pager.currentItem = 2
                }
            }

        })

        view.view_pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
                if (p0 != 2) {
                    val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(activity!!.currentFocus?.windowToken, 0)
                }
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                if (p0 == 0) {
                    view.tabs.getTabAt(0)!!.select()
                } else if (p0 == 1) {
                    view.tabs.getTabAt(1)!!.select()
                } else if (p0 == 2) {
                    view.tabs.getTabAt(2)!!.select()
                }
            }

        })
    }
}