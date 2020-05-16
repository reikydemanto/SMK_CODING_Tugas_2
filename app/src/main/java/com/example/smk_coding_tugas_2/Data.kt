package com.example.smk_coding_tugas_2


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("instansi")
    val instansi: String,
    @SerializedName("jam")
    val jam: String,
    @SerializedName("rencana_donor")
    val rencanaDonor: String
)