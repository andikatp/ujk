package com.example.ujk_andika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ujk_andika.menu.MenuActivityDetail

class MenuActivity : AppCompatActivity() {
    lateinit var btMakanan:Button
    lateinit var btMinuman:Button
    lateinit var btDessert:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btMakanan = findViewById(R.id.btMakanan)
        btMinuman = findViewById(R.id.btMinuman)
        btDessert = findViewById(R.id.btDessert)

        btMakanan.setOnClickListener {
            val intent = Intent(this, MenuActivityDetail::class.java)
            intent.putExtra("kategori", "makanan")
            startActivity(intent)
        }

        btMinuman.setOnClickListener {
            val intent = Intent(this, MenuActivityDetail::class.java)
            intent.putExtra("kategori", "minuman")
            startActivity(intent)
        }
        btDessert.setOnClickListener {
            val intent = Intent(this, MenuActivityDetail::class.java)
            intent.putExtra("kategori", "dessert")
            startActivity(intent)
        }
    }
}