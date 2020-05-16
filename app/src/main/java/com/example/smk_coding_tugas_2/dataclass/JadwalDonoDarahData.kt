package com.example.smk_coding_tugas_2.dataclass


import com.google.gson.annotations.SerializedName

data class JadwalDonoDarahData(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
)