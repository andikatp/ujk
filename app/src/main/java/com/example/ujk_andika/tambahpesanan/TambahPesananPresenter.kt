package com.example.ujk_andika.tambahpesanan


import android.util.Log
import com.example.ujk_andika.model.MenuCafe
import com.example.ujk_andika.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahPesananPresenter(val tambahPesananView: TambahPesananView) {
    fun getPesanan() {
        NetworkConfig.service()
            .getMenuDetailCafe("")
            .enqueue(object : Callback<MenuResultCafe> {
                override fun onResponse(
                    call: Call<MenuResultCafe>,
                    response: Response<MenuResultCafe>
                ) {
                    val body = response.body()
                    Log.d("body", body.toString())
                    tambahPesananView.onSuccessTambahPesanan(body?.menuCafes)
                }

                override fun onFailure(call: Call<MenuResultCafe>, t: Throwable) {
                    tambahPesananView.onErrorTambahPesanan(t.localizedMessage)
                }
            }
            )
    }
    fun tambahPesanan(nomeja:String, menu: MenuCafe){
        NetworkConfig.service()
            .tambahItemPesanan(nomeja, menu.idMenu)
            .enqueue(object :Callback<ResultSimple>{
                override fun onResponse(call: Call<ResultSimple>, response: Response<ResultSimple>) {
                    val body = response.body()
                    tambahPesananView.onSuccessTambahItemPesanan(body?.message)
                }

                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    tambahPesananView.onErrorTambahItemPesanan(t.localizedMessage)
                }

            })
    }

}