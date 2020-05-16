package com.example.smk_coding_tugas_2.modul

import androidx.fragment.app.FragmentActivity
import  androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smk_coding_tugas_2.modul.GithubFragment
import com.example.smk_coding_tugas_2.modul.MyFriendsFragment
import com.example.smk_coding_tugas_2.modul.ProfileFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {

    private  val JUMLAH_MENU = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{return MyFriendsFragment()
            }
            1->{return GithubFragment()
            }
            2->{return ProfileFragment()
            }
            else->{
                return GithubFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }

}