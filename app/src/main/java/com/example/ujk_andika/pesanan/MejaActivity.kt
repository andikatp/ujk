package com.example.ujk_andika.pesanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.ujk_andika.R
import com.example.ujk_andika.tambahpesanan.TambahPesananActivity

class MejaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meja)

        findViewById<Button>(R.id.btMejaLanjut).setOnClickListener {
            val intent = Intent(this, TambahPesananActivity::class.java).apply {
                putExtra("nomeja", findViewById<EditText>(R.id.etNomorMeja).text.toString().trim())
            }
            startActivity(intent)
        }
    }
}