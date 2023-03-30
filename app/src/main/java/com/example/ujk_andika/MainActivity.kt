package com.example.ujk_andika

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btMenu:Button
    lateinit var btPesanan:Button
    lateinit var btDapur:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMenu = findViewById(R.id.btMenu)
        btPesanan = findViewById(R.id.btPesanan)
        btDapur = findViewById(R.id.btDapur)

       menu()



    }
    private fun menu(){
        btMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



}