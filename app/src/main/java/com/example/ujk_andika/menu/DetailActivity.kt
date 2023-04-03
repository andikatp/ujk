package com.example.ujk_andika.menu

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.ujk_andika.R
import com.example.ujk_andika.model.Menu
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var ivImage: ImageView
    lateinit var  tvNama : TextView
    lateinit var tvDeskripsi : TextView
    lateinit var tvHarga : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvNama = findViewById(R.id.tvNamaTambah)
        ivImage = findViewById(R.id.ivImage)
        tvDeskripsi = findViewById(R.id.tvDeskripsi)
        tvHarga = findViewById(R.id.tvHargaTambah)



        val menu = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("menu", Menu::class.java)
        } else {
            intent.getParcelableExtra("menu")
        }

        menu?.let {
            Picasso.get().load("http://192.168.100.150" + java.net.URLDecoder.decode(it.foto)).into(findViewById<ImageView>(R.id.ivImage))
            tvNama.text = it.menu
            tvDeskripsi.text = it.deskripsi
            tvHarga.text = it.harga
        }

    }
}