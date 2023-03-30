package com.example.ujk_andika.menu

import com.example.ujk_andika.model.Menu

interface MenuView {
    fun onSuccessDataMenu(menu: List<Menu?>?)
    fun onErrorDataMenu(msg: String?)
}