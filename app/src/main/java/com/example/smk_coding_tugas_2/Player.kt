package com.example.smk_coding_tugas_2


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("countryOfBirth")
    val countryOfBirth: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: Any,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("shirtNumber")
    val shirtNumber: Int
)