package com.example.ujk_andika.menu

import com.example.ujk_andika.model.Menu
import com.google.gson.annotations.SerializedName

data class MenuResult(

	@field:SerializedName("Status")
	val status: String? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("Menu")
	val menu: List<Menu?>? = null
)