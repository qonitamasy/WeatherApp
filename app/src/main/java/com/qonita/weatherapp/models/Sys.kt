package com.qonita.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Sys (
    @field:SerializedName("type")
    val type: Double,

    @field:SerializedName("id")
    val id: Double,

    @field:SerializedName("sunrise")
    val sunrise:Long,

    @field:SerializedName("sunset")
    val sunset:Long,
        )


