package com.example.ujk_andika.tambahpesanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R
import com.example.ujk_andika.model.MenuCafe

class TambahPesananActivity : AppCompatActivity(), TambahPesananView {
    var nomeja:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pesanan)

        nomeja = intent.getStringExtra("nomeja").toString()
        refreshTambahPesanan()
    }

    private fun refreshTambahPesanan(){
        TambahPesananPresenter(this).getPesanan()
    }

    override fun onSuccessTambahPesanan(data: List<MenuCafe?>?) {
        Log.d("menu", data.toString());
        findViewById<RecyclerView>(R.id.rvTambahPesanan).adapter = TambahPesananAdapter(data)
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