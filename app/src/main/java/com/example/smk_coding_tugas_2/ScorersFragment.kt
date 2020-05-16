package com.example.smk_coding_tugas_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import apiRequest
import data.DonorService
import dismissLoading
import httpClient
import kotlinx.android.synthetic.main.fragment_scorers.*
import showLoading
import tampilToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class ScorersFragment: Fragment() {

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

//        callApiGetGithubUser()
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
        listJadwalDonor.adapter = JadwalDonorAdapter(context!!, jadwalDonor) {
            val githubUser = it
            tampilToast(context!!, githubUser.instansi)
        }
    }

//    private fun callApiGetGithubUser() {
//        showLoading(context!!, swipeRefreshLayout)
//        val httpClient = httpClient()
//        val apiRequest = apiRequest<ScorersService>(httpClient)
//        val call = apiRequest.getScorers()
//        call.enqueue(object : Callback<List<TopScorers>> {
//            override fun onFailure(call: Call<TopScorers>, t: Throwable) {
//                dismissLoading(swipeRefreshLayout)
//            }
//
//            override fun onResponse(call: Call<TopScorers>, response: Response<TopScorers>) {
//                dismissLoading(swipeRefreshLayout)
//                when {
//                    response.isSuccessful ->
//                        when {
//                            response.body()?.size != 0 ->
//                                tampilGithubUser(response.body()!!)
//                            else -> {
//                                tampilToast(context!!, "Berhasil")
//                            }
//                        }
//                    else -> {
//                        tampilToast(context!!, "Gagal")
//                    }
//                }
//            }
//            override fun onFailure(call: Call<List<Scorer>>, t: Throwable) {
//                dismissLoading(swipeRefreshLayout)
//            }
//            override fun onResponse(call: Call<List<Scorer>>, response:
//            Response<List<Scorer>>) {
//                dismissLoading(swipeRefreshLayout)
//                when {
//                    response.isSuccessful ->
//                        when {
//                            response.body()?.size != 0 ->
//                                tampilGithubUser(response.body()!!)
//                            else -> {
//                                tampilToast(context!!, "Berhasil")
//                            }
//                        }
//                    else -> {
//                        tampilToast(context!!, "Gagal")
//                    }
//                }
//            }

//            override fun onFailure(call: Call<List<TopScorers>>, t: Throwable) {
//                dismissLoading(swipeRefreshLayout)
//            }
//
//            override fun onResponse(
//                call: Call<List<TopScorers>>,
//                response: Response<List<TopScorers>>
//            ) {
//                dismissLoading(swipeRefreshLayout)
//                when {
//                    response.isSuccessful ->
//                        when {
//                            response.body()?.size != 0 ->
//                                tampilGithubUser(response.body()!!)
//                            else -> {
//                                tampilToast(context!!, "Berhasil")
//                            }
//                        }
//                    else -> {
//                        tampilToast(context!!, "Gagal")
//                    }
//                }
//            }
//        })
//    }
//
//    private fun tampilGithubUser(listtopscorers: List<TopScorers>) {
//        rvlistScorer.layoutManager = LinearLayoutManager(context)
//        rvlistScorer.adapter = ScorersAdapter(context!!,listtopscorers){}
////        listScorer.adapter = ScorersAdapter(context!!, listtopscorers) {
////            val githubUser = it
////            tampilToast(context!!, githubUser.competition.name)
////        }
//    }


}