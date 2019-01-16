package com.example.user.gtaproject

import android.support.v4.app.Fragment

class XboxFragment: Fragment() {

    companion object {
        internal var xboxFragment = XboxFragment()

        fun newInstance(): XboxFragment{
            return xboxFragment
        }
    }
}