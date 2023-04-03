package com.example.ujk_andika.tambahpesanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R
import com.example.ujk_andika.dapur.DapurActivity
import com.example.ujk_andika.model.Menu

class TambahPesananActivity : AppCompatActivity(), TambahPesananView {
    var nomeja: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pesanan)

        nomeja = intent.getStringExtra("nomeja").toString()
        refreshTambahPesanan()
        dapur()
    }

    private fun dapur(){
        findViewById<Button>(R.id.btDapur).setOnClickListener {
            val intent = Intent(this, DapurActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun refreshTambahPesanan() {
        TambahPesananPresenter(this).getPesanan()
    }

    fun tambahPesanan(menu: Menu) {
        TambahPesananPresenter(this).tambahPesanan(nomeja, menu)
    }

    override fun onSuccessTambahPesanan(data: List<Menu?>?) {
        findViewById<RecyclerView>(R.id.rvTambahPesanan).adapter = TambahPesananAdapter(data).apply {
            tambahClicked {
                tambahPesanan(it)
            }
        }
    }

    override fun onErrorTambahPesanan(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessTambahItemPesanan(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onErrorTambahItemPesanan(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}