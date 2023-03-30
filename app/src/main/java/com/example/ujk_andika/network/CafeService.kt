package com.example.ujk_andika.network


import com.example.ujk_andika.menu.MenuResult
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CafeService {
    @FormUrlEncoded
    @POST("menu.php")
    fun getMenuDetail(
        @Field("kategori") kategori: String?
    ): Call<MenuResult>
}