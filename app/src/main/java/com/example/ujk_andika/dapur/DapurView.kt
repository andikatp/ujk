package com.example.ujk_andika.dapur

import Pesanan

interface DapurView {
    fun onSuccessDapur(data:List<Pesanan?>?)
    fun onErrorDapur(msg:String?)
    fun onSuccessDeleteDapur(msg:String?)
    fun onErrorDeleteDapur(msg:String?)
}