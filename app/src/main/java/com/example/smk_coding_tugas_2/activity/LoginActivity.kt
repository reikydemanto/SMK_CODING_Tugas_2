package com.example.smk_coding_tugas_2.activity

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.smk_coding_tugas_2.R
import com.example.smk_coding_tugas_2.encryptMd5
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.reflect.Method
import java.math.BigInteger

class LoginActivity : AppCompatActivity() {

    private var hasilmd5: String? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerbutton.setOnClickListener{ RegisterPage() }

        progressDialog = ProgressDialog(this)

        val id_user = idUser
        if (id_user != "null") {
            gotoCourseActivity()
        }

        buttonlogin.setOnClickListener { btnMD5() }
    }

    fun btnMD5() {
        val md5input = txtpassword!!.text.toString().toByteArray()
        var md5Data: BigInteger? = null
        try {
            md5Data = BigInteger(1, encryptMd5.encryptMD5(md5input))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        var md5Str = md5Data!!.toString(16)
        if (md5Str.length < 32) {
            md5Str = "0$md5Str"
        }
        hasilmd5 = md5Str

        if(txtusername!!.text.toString().isEmpty()){
            txtusername.error = "Harap isi email anda"
        } else if(txtpassword!!.text.toString().isEmpty()){
            txtpassword.error = "Harap isi password"
        }else {
            login()
        }
    }

    private fun login() {
        progressDialog!!.setMessage("Login Process...")
        showDialog()

        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, "https://reikydemanto.000webhostapp.com/login.php",
            Response.Listener { response ->
                if (response.contains("success")) {
                    hideDialog()
                    val id = response.split(";").toTypedArray()[1]
                    setPreference(id)
                    gotoCourseActivity()
                } else {
                    hideDialog()
                    Toast.makeText(applicationContext,"Gagal Login",Toast.LENGTH_LONG).show()
                }
            },
            Response.ErrorListener {
                hideDialog()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["username"] = txtusername.text.toString()
                params["password"] = hasilmd5!!
                return params
            }
        }
        Volley.newRequestQueue(this).add(stringRequest)
    }

    private fun gotoCourseActivity() {
        val intent = Intent(applicationContext, HomeActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }

    private fun showDialog() {
        if (!progressDialog!!.isShowing) progressDialog!!.show()
    }

    private fun hideDialog() {
        if (progressDialog!!.isShowing) progressDialog!!.dismiss()
    }

    fun setPreference(id: String?) {
        val mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val editor = mSettings.edit()
        editor.putString("id_user", id)
        editor.apply()
    }

    private val idUser: String
        private get() {
            val preferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
            return preferences.getString("id_user", "null")
        }

    private fun RegisterPage() {
        val intent = Intent(this,
            RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}
