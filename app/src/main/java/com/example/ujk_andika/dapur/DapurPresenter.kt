package com.example.ujk_andika.dapur

import Pesanan
import PesananResult
import com.example.ujk_andika.network.NetworkConfig
import com.example.ujk_andika.tambahpesanan.ResultSimple
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DapurPresenter(val dapurView: DapurView) {
    fun getPesanan() {
        NetworkConfig.service()
            .getDapur("")
            .enqueue(object : Callback<PesananResult> {
                override fun onResponse(
                    call: Call<PesananResult>,
                    response: Response<PesananResult>
                ) {
                    val body = response.body()
                    dapurView.onSuccessDapur(body?.pesanan)
                }

                override fun onFailure(call: Call<PesananResult>, t: Throwable) {
                    dapurView.onErrorDapur(t.localizedMessage)
                }
            }
            )
    }

    fun deletePesanan(pesanan: Pesanan) {
        NetworkConfig.service()
            .deletePesanan(pesanan.idPesanan)
            .enqueue(object : Callback<ResultSimple> {
                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    dapurView.onSuccessDeleteDapur(body?.message)
                }

                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    dapurView.onErrorDeleteDapur(t.localizedMessage)
                }

            })
    }
}