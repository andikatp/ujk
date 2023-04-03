package com.example.ujk_andika.pesanan

import Pesanan
import PesananResult
import com.example.ujk_andika.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PesananPresenter(val pesananView: PesananActivity) {
    fun getPesanan(){
        NetworkConfig.service()
            .getPesanan("")
            .enqueue(object: Callback<PesananResult> {
                override fun onResponse(call: Call<PesananResult>, response: Response<PesananResult>) {
                    val body = response.body()
                    pesananView.onSuccessPesanan(body?.pesanan)
                }

                override fun onFailure(call: Call<PesananResult>, t: Throwable) {
                    pesananView.onErrorPesanan(t.localizedMessage)
                }


            }
            )
    }


}