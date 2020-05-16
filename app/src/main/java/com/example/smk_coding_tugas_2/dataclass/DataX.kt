package com.example.smk_coding_tugas_2.dataclass


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("id")
    val id: String,
    @SerializedName("jumlah")
    val jumlah: String,
    @SerializedName("provinsi")
    val provinsi: String,
    @SerializedName("unit")
    val unit: String
)