package com.example.ujk_andika.menu


import com.example.ujk_andika.model.Menu
import com.example.ujk_andika.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuPresenter(val menuView: MenuView) {
    fun getMenu(kategori: String) {
        NetworkConfig.service().getMenuDetail(kategori).enqueue(object : Callback<MenuResult> {
            override fun onResponse(call: Call<MenuResult>, response: Response<MenuResult>) {
                val body = response.body()
                if (body?.status == "200") {
                    menuView.onSuccessDataMenu(body.menu)
                } else {
                    menuView.onErrorDataMenu(body?.message)
                }
            }

            override fun onFailure(call: Call<MenuResult>, t: Throwable) {
                menuView.onErrorDataMenu(t.localizedMessage)
            }

        }
        )
    }
}