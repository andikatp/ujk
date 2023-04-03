package com.example.ujk_andika.model


import com.google.gson.annotations.SerializedName

data class  MenuCafe(

    @field:SerializedName("id_menu")
    val idMenu: Int? = null,

    @field:SerializedName("harga")
    val harga: String? = null,

    @field:SerializedName("Foto")
    val foto: String? = null,

    @field:SerializedName("kategori")
    val kategori: String? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("menu")
    val menu: String? = null
) : java.io.Serializable