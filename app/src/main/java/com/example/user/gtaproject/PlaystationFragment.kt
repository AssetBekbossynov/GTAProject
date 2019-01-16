package com.example.user.gtaproject

import android.support.v4.app.Fragment

class PlaystationFragment: Fragment() {

    companion object {
        internal var playstationFragment = PlaystationFragment()

        fun newInstance(): PlaystationFragment{
            return playstationFragment
        }
    }
}