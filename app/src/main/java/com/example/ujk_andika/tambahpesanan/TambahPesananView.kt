package com.example.ujk_andika.tambahpesanan

import com.example.ujk_andika.model.MenuCafe

interface TambahPesananView {
    fun onSuccessTambahPesanan(data:List<MenuCafe?>?)
    fun onErrorTambahPesanan(msg:String?)

    fun onSuccessTambahItemPesanan(msg:String?)
    fun onErrorTambahItemPesanan(msg:String?)
}