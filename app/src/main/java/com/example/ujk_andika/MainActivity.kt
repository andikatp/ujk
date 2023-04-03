package com.example.ujk_andika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ujk_andika.dapur.DapurActivity
import com.example.ujk_andika.menu.MenuActivity
import com.example.ujk_andika.pesanan.MejaActivity

class MainActivity : AppCompatActivity() {
    lateinit var btMenu: Button
    lateinit var btPesanan: Button
    lateinit var btDapur: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMenu = findViewById(R.id.btMenu)
        btPesanan = findViewById(R.id.btPesanan)
        btDapur = findViewById(R.id.btDapur)
        menu()
        pesanan()
        dapur()
    }

    private fun menu() {
        btMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun pesanan(){
        btPesanan.setOnClickListener {
            val intent = Intent(this, MejaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun dapur(){
        btDapur.setOnClickListener {
            val intent = Intent(this, DapurActivity::class.java)
            startActivity(intent)
        }
    }

}