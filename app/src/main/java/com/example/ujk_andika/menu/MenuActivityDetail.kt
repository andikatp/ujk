package com.example.ujk_andika.menu

import MenuAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R
import com.example.ujk_andika.model.Menu

class MenuActivityDetail : AppCompatActivity() , MenuView {
    var kategori:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        val intent = getIntent()
        kategori = intent.getStringExtra("kategori").toString()

        refreshMenu()
    }

    fun refreshMenu(){
        MenuPresenter(this).getMenu(kategori)
    }

    override fun onSuccessDataMenu(menu: List<Menu?>?) {
       findViewById<RecyclerView>(R.id.ListMenu).adapter = MenuAdapter(menu)


    }

    override fun onErrorDataMenu(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}