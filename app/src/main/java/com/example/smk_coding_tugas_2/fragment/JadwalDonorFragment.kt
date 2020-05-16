package com.example.smk_coding_tugas_2.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import apiRequest
import com.example.smk_coding_tugas_2.dataclass.Data
import com.example.smk_coding_tugas_2.dataclass.JadwalDonoDarahData
import com.example.smk_coding_tugas_2.adapter.JadwalDonorAdapter
import com.example.smk_coding_tugas_2.R
import data.DonorService
import dismissLoading
import httpClient
import kotlinx.android.synthetic.main.fragment_scorers.*
import showLoading
import tampilToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JadwalDonorFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scorers,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callApiJadwalDonor()
    }

    private fun callApiJadwalDonor() {
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<DonorService>(httpClient)
        val call = apiRequest.getJadwalDonor()
        call.enqueue(object : Callback<JadwalDonoDarahData> {
            override fun onFailure(call: Call<JadwalDonoDarahData>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<JadwalDonoDarahData>,
                response: Response<JadwalDonoDarahData>
            ) {
                dismissLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.data?.size != 0 ->
                                tampilJadwalDonor(response.body()!!.data)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                                Log.d("ANJIING", response.body()!!.status)
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
        })
    }
    private fun tampilJadwalDonor(jadwalDonor: List<Data>) {
        listJadwalDonor.layoutManager = LinearLayoutManager(context)
        listJadwalDonor.adapter =
            JadwalDonorAdapter(
                context!!,
                jadwalDonor
            ) {
                val githubUser = it
                tampilToast(context!!, githubUser.instansi)
            }
    }

}