package com.example.ujk_andika.pesanan

import Pesanan

interface PesananView {
    fun onSuccessPesanan(data:List<Pesanan?>?)
    fun onErrorPesanan(msg:String?)
    fun onSuccessDeletePesanan(msg:String?)
    fun onErrorDeletePesanan(msg:String?)

    fun onSuccessTotalPesanan(msg:String?)
    fun onErrorTotalPesanan(msg:String?)

    fun onSuccessKirimDapur(msg:String?)
    fun onErrorKirimDapur(msg:String?)
}