package com.example.smk_coding_tugas_2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import apiRequest
import com.example.smk_coding_tugas_2.R
import com.example.smk_coding_tugas_2.adapter.JadwalDonorAdapter
import com.example.smk_coding_tugas_2.adapter.StokDarahAdapter
import com.example.smk_coding_tugas_2.dataclass.DataX
import com.example.smk_coding_tugas_2.dataclass.StokDarahData
import data.DonorService
import dismissLoading
import httpClient
import kotlinx.android.synthetic.main.fragment_jadwal_donor.*
import kotlinx.android.synthetic.main.fragment_stok_darah.*
import kotlinx.android.synthetic.main.fragment_stok_darah.swipeRefreshLayout
import showLoading
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tampilToast

class StokDarahFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stok_darah,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callApiStokDarah()
    }

    private fun callApiStokDarah() {
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<DonorService>(httpClient)
        val call = apiRequest.getStokDarah()
        call.enqueue(object : Callback<StokDarahData> {
            override fun onFailure(call: Call<StokDarahData>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(call: Call<StokDarahData>, response: Response<StokDarahData>) {
                dismissLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.data?.size != 0 ->
                                tampilStokDonor(response.body()!!.data)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
//            override fun onFailure(call: Call<StokDarahData>, t: Throwable) {
//                dismissLoading(swipeRefreshLayout)
//            }
//
//            override fun onResponse(
//                call: Call<StokDarahData>,
//                response: Response<StokDarahData>
//            ) {
//                dismissLoading(swipeRefreshLayout)
//                when {
//                    response.isSuccessful ->
//                        when {
//                            response.body()?.data?.size != 0 ->
//                                tampilStokDonor(response.body()!!.data)
//                            else -> {
//                                tampilToast(context!!, "Berhasil")
//                            }
//                        }
//                    else -> {
//                        tampilToast(context!!, "Gagal")
//                    }
//                }
//            }
        })
    }
    private fun tampilStokDonor(stokDarah: List<DataX>) {
        listStokDarah.layoutManager = LinearLayoutManager(context)
        listStokDarah.adapter =
            StokDarahAdapter(
                context!!,
                stokDarah
            ) {
                val githubUser = it
                tampilToast(context!!, githubUser.provinsi)
            }
    }
}