package com.example.ujk_andika.tambahpesanan

import com.example.ujk_andika.model.Menu

interface TambahPesananView {
    fun onSuccessTambahPesanan(data:List<Menu?>?)
    fun onErrorTambahPesanan(msg:String?)

    fun onSuccessTambahItemPesanan(msg:String?)
    fun onErrorTambahItemPesanan(msg:String?)
}