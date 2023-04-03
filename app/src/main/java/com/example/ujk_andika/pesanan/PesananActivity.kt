package com.example.ujk_andika.pesanan

import Pesanan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R


class PesananActivity : AppCompatActivity(), PesananView {
    var nomeja:String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)

        nomeja = intent.getStringExtra("nomeja").toString()
        refreshPesanan()


    }

    private fun refreshPesanan(){
        PesananPresenter(this).getPesanan()
    }

    override fun onSuccessPesanan(data: List<Pesanan?>?) {
        TODO("Not yet implemented")
    }


    override fun onErrorPesanan(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessDeletePesanan(msg: String?) {
        Toast.makeText(this, msg?:"", Toast.LENGTH_SHORT).show()
        refreshPesanan()
    }

    override fun onErrorDeletePesanan(msg: String?) {
        Toast.makeText(this, msg?:"", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessTotalPesanan(msg: String?) {
        findViewById<TextView>(R.id.totalPesanan).text = msg
    }

    override fun onErrorTotalPesanan(msg: String?) {
        Toast.makeText(this, msg?:"", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessKirimDapur(msg: String?) {
        Toast.makeText(this, msg?:"", Toast.LENGTH_SHORT).show()
        refreshPesanan()
    }

    override fun onErrorKirimDapur(msg: String?) {
        Toast.makeText(this, msg?:"", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        refreshPesanan()
    }
}