package com.example.smk_coding_tugas_2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smk_coding_tugas_2.fragment.JadwalDonorFragment
import com.example.smk_coding_tugas_2.fragment.StokDarahFragment
import com.example.smk_coding_tugas_2.fragment.ProfileUserFragment

class HomeAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private  val JUMLAH_MENU = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{return StokDarahFragment()
            }
            1->{return JadwalDonorFragment()
            }
            2->{return ProfileUserFragment()
            }
            else->{
                return StokDarahFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}