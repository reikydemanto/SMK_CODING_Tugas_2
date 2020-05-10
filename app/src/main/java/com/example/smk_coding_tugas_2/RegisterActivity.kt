package com.example.smk_coding_tugas_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.github_user_item.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loginbutton.setOnClickListener{ LoginPage() }

        buttonregister.setOnClickListener{ RegisterAction() }
    }

//    private fun RegisterAction() {
//        var username : String = ""
//        var password : String = ""
//        username = txtusername.text.toString()
//    }

    private fun LoginPage() {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}
