package com.example.user.gtaproject

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.expand_item.view.*
import kotlinx.android.synthetic.main.fragment_content.*

class GTAFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.text = getString(R.string.gta_title)

        div1.div_title.text = "Обычные чит-коды"
        div1.cheats.text = getString(R.string.gta_simple)

        div1.setOnClickListener {
            div1.div_content.toggle()
            if (div1.div_content.isExpanded){
                div1.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0)
            }else{
                div1.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0)
            }
        }

        div2.div_title.text = "Дополнительные чит-коды"
        div2.cheats.text = getString(R.string.gta_additional)

        div2.setOnClickListener {
            div2.div_content.toggle()
            if (div2.div_content.isExpanded){
                div2.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0)
            }else{
                div2.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0)
            }
        }

        div3.div_title.text = "Уникальные чит-коды"
        div3.cheats.text = getString(R.string.gta_unique)

        div3.setOnClickListener {
            div3.div_content.toggle()
            if (div3.div_content.isExpanded){
                div3.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0)
            }else{
                div3.div_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0)
            }
        }

        div4.visibility = View.GONE

        instructions.text = getString(R.string.gta_instruction)
    }
}