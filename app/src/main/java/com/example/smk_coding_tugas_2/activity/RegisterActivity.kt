package com.example.smk_coding_tugas_2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.smk_coding_tugas_2.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        login_button.setOnClickListener{ LoginPage() }

//        registerbutton.setOnClickListener{ RegisterAction() }
    }

//    MANGKRAK
//
//    private fun RegisterAction() {
//        var username : String = ""
//        var password : String = ""
//        username = txtusername.text.toString()
//        password = txtpassword.text.toString()
//        when{
//            username.isEmpty()->txtusername.error ="Username Harus Diisi"
//            password.isEmpty()->txtpassword.error ="Password Harus Diisi"
//            else->{
//                val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
//                var editor = sharedPreference.edit()
//                editor.putString("username","Anupam")
//                editor.putLong("l",100L)
//                editor.commit()
//            }
//        }
//    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun LoginPage() {
        val intent = Intent(this,
            LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
