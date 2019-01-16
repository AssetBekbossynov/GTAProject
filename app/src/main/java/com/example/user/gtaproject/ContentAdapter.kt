package com.example.user.gtaproject

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ContentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
    private val NUM = 3

    override fun getItem(p0: Int): Fragment {
        return when(p0){
            0 -> PCFragment.newInstance()
            1 -> XboxFragment.newInstance()
            2 -> PlaystationFragment.newInstance()
            else -> PCFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return NUM;
    }
}