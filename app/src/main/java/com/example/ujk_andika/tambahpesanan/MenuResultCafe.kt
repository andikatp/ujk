package com.example.ujk_andika.tambahpesanan

import com.example.ujk_andika.model.MenuCafe
import com.google.gson.annotations.SerializedName

data class MenuResultCafe(
    @field:SerializedName("Menu")
    val menuCafes: List<MenuCafe?>? = null
)
