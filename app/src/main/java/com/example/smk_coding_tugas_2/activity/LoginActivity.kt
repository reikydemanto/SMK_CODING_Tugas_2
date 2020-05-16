package com.example.smk_coding_tugas_2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smk_coding_tugas_2.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerbutton.setOnClickListener{ RegisterPage() }
    }

    private fun RegisterPage() {
        val intent = Intent(this,
            RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}
