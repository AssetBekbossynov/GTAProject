package com.example.user.gtaproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.expand_item.view.*
import kotlinx.android.synthetic.main.fragment_content.*


class PCFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.text = getString(R.string.gtav_pc_title)

        div1.div_title.text = "Оружие"
        div1.cheats.text = getString(R.string.gtav_pc_weapons)

        div1.setOnClickListener {
            div1.div_content.toggle()
            if (div1.div_content.isExpanded){
                div1.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0)
            }else{
                div1.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0)
            }
        }

        div2.div_title.text = "Геймплей"
        div2.cheats.text = getString(R.string.gtav_pc_gameplay)

        div2.setOnClickListener {
            div2.div_content.toggle()
            if (div2.div_content.isExpanded){
                div2.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0)
            }else{
                div2.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0)
            }
        }

        div3.div_title.text = "Транспорт"
        div3.cheats.text = getString(R.string.gtav_pc_vehicle)

        div3.setOnClickListener {
            div3.div_content.toggle()
            if (div3.div_content.isExpanded){
                div3.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0)
            }else{
                div3.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0)
            }
        }

        warning.text = getString(R.string.gtav_warning)
        instructions.text = getString(R.string.gtav_instructions)

        div4.visibility = View.GONE
    }

    companion object {

        internal var pcFragment = PCFragment()

        fun newInstance(): PCFragment {
            return pcFragment
        }
    }

}