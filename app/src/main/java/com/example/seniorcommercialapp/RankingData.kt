package com.example.seniorcommercialapp

import com.google.gson.annotations.SerializedName

data class RankingData(

    @SerializedName("pcode")
    val pcode: String,

    @SerializedName("prank")
    val prank: Int,

    @SerializedName("ptitle")
    val ptitle: String,

    @SerializedName("pprice")
    val pprice: String,

    @SerializedName("pimgurl")
    val pimgurl: String

)
