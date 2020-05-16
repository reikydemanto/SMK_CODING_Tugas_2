package com.example.smk_coding_tugas_2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.example.smk_coding_tugas_2.R
import com.example.smk_coding_tugas_2.adapter.HomeAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    val menuTeks = arrayOf("Stok Darah","Jadwal Donor","Profile")
    val menuIcon = arrayOf(
        R.drawable.ic_bloods,
        R.drawable.ic_schedule,
        R.drawable.ic_profile
    )

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
