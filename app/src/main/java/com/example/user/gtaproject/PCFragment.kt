package com.example.user.gtaproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_content.*


class PCFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weapons.setOnClickListener {
            weapons_content.toggle()
        }

        gameplay.setOnClickListener {
            gameplay_content.toggle()
        }

        vehicle.setOnClickListener {
            vehicle_content.toggle()
        }
    }

    companion object {

        internal var pcFragment = PCFragment()

        fun newInstance(): PCFragment {
            return pcFragment
        }
    }

}