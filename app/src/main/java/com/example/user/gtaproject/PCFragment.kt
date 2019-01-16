package com.example.user.gtaproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class PCFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        view.setOnClickListener {
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    companion object {

        internal var pcFragment = PCFragment()

        fun newInstance(): PCFragment {
            return pcFragment
        }
    }

}