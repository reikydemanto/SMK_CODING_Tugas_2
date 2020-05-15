package com.example.smk_coding_tugas_2


import com.google.gson.annotations.SerializedName

data class TopScorers(
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("scorers")
    val scorers: List<Scorer>,
    @SerializedName("season")
    val season: Season
)