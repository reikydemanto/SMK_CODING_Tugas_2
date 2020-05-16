package com.example.smk_coding_tugas_2.modul

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smk_coding_tugas_2.R
import kotlinx.android.synthetic.main.fragment_my_friend.*

class MyFriendsFragment : Fragment() {

    lateinit var listTeman : ArrayList<MyFriend>
    private fun simulasiDataTeman() {
        listTeman = ArrayList()
        listTeman.add(
            MyFriend(
                "Fakhry", "Laki-laki", "fakhry@smkcoding.id", "081123123123",
                "Malang"
            )
        )
        listTeman.add(
            MyFriend(
                "Ahmad",
                "Laki-laki",
                "ahmad@smkcoding.id",
                "085123123123",
                "Malang"
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_friend,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun tampilTeman() {
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter =
            MyFriendAdapter(
                activity!!,
                listTeman
            )
    }

    private fun initView() {
        simulasiDataTeman()
        tampilTeman()
    }

    }