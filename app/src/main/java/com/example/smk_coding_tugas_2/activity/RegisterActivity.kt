package com.example.smk_coding_tugas_2.activity

import android.app.ProgressDialog
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
import kotlinx.android.synthetic.main.activity_register.*
import java.math.BigInteger

class RegisterActivity : AppCompatActivity() {

    private var hasilmd5: String? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        progressDialog = ProgressDialog(this)

        login_button.setOnClickListener{ LoginPage() }

        button_register.setOnClickListener{ btnMD5() }
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
            txtusername.error = "Harap isi Username anda"
        } else if(txtpassword!!.text.toString().isEmpty()){
            txtpassword.error = "Harap isi password"
        }else if(txtemail!!.text.toString().isEmpty()){
            txtemail.error = "Harap isi Email anda"
        }else {
            RegisterAction()
        }
    }

    private fun showDialog() {
        if (!progressDialog!!.isShowing) progressDialog!!.show()
    }

    private fun hideDialog() {
        if (progressDialog!!.isShowing) progressDialog!!.dismiss()
    }

    private fun RegisterAction() {
        progressDialog!!.setMessage("Register Process...")
        showDialog()

        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, "https://reikydemanto.000webhostapp.com/register.php",
            Response.Listener { response ->
                if (response.contains("success")) {
                    hideDialog()
                    gotoLoginActivity()
                } else {
                    hideDialog()
                    Toast.makeText(applicationContext,"Gagal Register",Toast.LENGTH_LONG).show()
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
                params["email"] = txtemail.text.toString()

                return params
            }
        }
        Volley.newRequestQueue(this).add(stringRequest)
    }

    private fun gotoLoginActivity() {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        tampilToast("Berhasil Mendaftar")
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }

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
