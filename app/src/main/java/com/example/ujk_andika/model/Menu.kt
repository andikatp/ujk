package com.example.ujk_andika.model

import com.google.gson.annotations.SerializedName

data class Menu(

	@field:SerializedName("id_menu")
	val idMenu: String? = null,

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
)