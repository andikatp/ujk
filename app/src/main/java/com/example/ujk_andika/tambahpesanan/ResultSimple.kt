package com.example.ujk_andika.tambahpesanan

import com.google.gson.annotations.SerializedName

data class ResultSimple(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)