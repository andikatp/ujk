package com.example.ujk_andika.dapur

import Pesanan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R

class DapurAdapter(val pesanan: List<Pesanan?>?) : RecyclerView.Adapter<DapurAdapter.MyHolder>() {
    private var onItemCallBackListenerDapur: OnItemCallBackListenerDapur? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_dapur, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = pesanan?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(pesanan?.get(position))
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pesanan: Pesanan?) {
            val waktu = pesanan?.waktu.toString().split(" ")

            itemView.findViewById<TextView>(R.id.tvNomorMeja).text = pesanan?.noMeja
            itemView.findViewById<TextView>(R.id.tvNamaMenu).text = pesanan?.menu
            itemView.findViewById<TextView>(R.id.tvTanggalMenu).text = waktu[0]
            itemView.findViewById<TextView>(R.id.tvWaktuMenu).text = waktu[1]
            itemView.findViewById<Button>(R.id.btHapusDapur).setOnClickListener {
                onItemCallBackListenerDapur?.hapus(pesanan!!)
            }
        }
    }

    fun selesaiClicked(onTap: (pesanan: Pesanan) -> Unit) {
        onItemCallBackListenerDapur = object : OnItemCallBackListenerDapur {
            override fun hapus(pesanan: Pesanan) {
                onTap(pesanan)
            }

        }
    }

    interface OnItemCallBackListenerDapur {
        fun hapus(pesanan: Pesanan)
    }
}