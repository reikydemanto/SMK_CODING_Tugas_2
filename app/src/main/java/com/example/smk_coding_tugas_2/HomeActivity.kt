package com.example.smk_coding_tugas_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    val menuTeks = arrayOf("League","Jadwal Donor","Club")
    val menuIcon = arrayOf(R.drawable.ic_league,R.drawable.ic_schedule,R.drawable.ic_club)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val adapter = HomeAdapter(this)
        view_pager.setAdapter(adapter)
        TabLayoutMediator(tab_layout ,view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = menuTeks[position]
                tab.icon = ResourcesCompat.getDrawable(resources,menuIcon[position],null)}).attach()
    }
}
