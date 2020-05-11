package com.example.smk_coding_tugas_2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private  val JUMLAH_MENU = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{return LeagueFragment()}
            1->{return ScorersFragment()}
            2->{return ClubFragment()}
            else->{
                return LeagueFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}