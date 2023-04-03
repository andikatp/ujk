package com.example.ujk_andika.network
import PesananResult
import com.example.ujk_andika.menu.MenuResult

import com.example.ujk_andika.tambahpesanan.MenuResultCafe
import com.example.ujk_andika.tambahpesanan.ResultSimple
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CafeService {
    @FormUrlEncoded
    @POST("menu/menu.php")
    fun getMenuDetail(
        @Field("kategori") kategori: String?
    ): Call<MenuResult>

    @FormUrlEncoded
    @POST("menu/menuAll.php")
    fun getMenuDetailCafe(
        @Field("kategori") kategori: String?
    ): Call<MenuResultCafe>

    @FormUrlEncoded
    @POST("pesanan/pesanan.php")
    fun getPesanan(@Field("nomeja") nomeja:String?): Call<PesananResult>

    @FormUrlEncoded
    @POST("pesanan/tambahitempesanan.php")
    fun tambahItemPesanan(@Field("nomeja") nomeja:String?,
                          @Field("id_menu") id_menu:Int?
    ): Call<ResultSimple>

    @FormUrlEncoded
    @POST("dapur/dapur.php")
    fun getDapur(@Field("nomeja") nomeja:String?): Call<PesananResult>

    @FormUrlEncoded
    @POST("pesanan/deletepesanan.php")
    fun deletePesanan(@Field("id_pesanan") id_pesanan:Int?):Call<ResultSimple>
}