package com.example.smk_coding_tugas_2.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smk_coding_tugas_2.R
import com.example.smk_coding_tugas_2.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile_user.*

class ProfileUserFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_user,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logoutbutton.setOnClickListener{ logoutFunction()}
    }

    private fun logoutFunction() {
        val preferences: SharedPreferences = activity!!.getSharedPreferences("Settings", Context.MODE_PRIVATE)
        preferences.edit().clear().commit()
        val intent = Intent(activity!!.getApplicationContext(), LoginActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }
}