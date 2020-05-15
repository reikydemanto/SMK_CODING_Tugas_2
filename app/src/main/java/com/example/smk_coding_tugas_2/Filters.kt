package com.example.smk_coding_tugas_2


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("limit")
    val limit: Int
)