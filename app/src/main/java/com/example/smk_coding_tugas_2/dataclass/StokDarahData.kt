package com.example.smk_coding_tugas_2.dataclass


import com.google.gson.annotations.SerializedName

data class StokDarahData(
    @SerializedName("data")
    val `data`: List<DataX>,
    @SerializedName("status")
    val status: String
)