package com.example.ujk_andika.dapur

import Pesanan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.MainActivity
import com.example.ujk_andika.R
import com.example.ujk_andika.tambahpesanan.TambahPesananAdapter

class DapurActivity : AppCompatActivity(), DapurView {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dapur)

        refreshDapur()


    }

    private fun refreshDapur() {
        DapurPresenter(this).getPesanan()
            }

    override fun onSuccessDapur(data: List<Pesanan?>?) {
        findViewById<RecyclerView>(R.id.rvDapur).adapter = DapurAdapter(data).apply {
            selesaiClicked {
                hapusPesanan(it)
            }
        }
    }

    override fun onBackPressed() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

    }
    override fun onErrorDapur(msg: String?) {
        val recyclerView = findViewById<RecyclerView>(R.id.rvDapur)
        val noDataTextView = findViewById<TextView>(R.id.tvNoData)

        recyclerView.visibility = View.GONE
        noDataTextView.visibility = View.VISIBLE
        noDataTextView.text = "Anda belum memesan apapun, silahkan kirim pesanan anda ke dapur!"

    }

    fun hapusPesanan(pesanan: Pesanan)
    {
        DapurPresenter(this).deletePesanan(pesanan)
        refreshDapur()
    }

    override fun onSuccessDeleteDapur(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onErrorDeleteDapur(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}