package com.example.ujk_andika.tambahpesanan

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R
import com.example.ujk_andika.model.Menu
import com.squareup.picasso.Picasso


class TambahPesananAdapter(val menu: List<Menu?>?) :
    RecyclerView.Adapter<TambahPesananAdapter.MyHolder>() {
    private var onItemCallBackListener: OnItemCallBackListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tambah_pesanan, parent, false)

        return MyHolder(v)
    }

    override fun getItemCount(): Int = menu?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
         holder.bind(menu?.get(position))


    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(menu: Menu?) {
            Picasso.get().load("http://192.168.100.150" + java.net.URLDecoder.decode(menu?.foto))
                .into(itemView.findViewById<ImageView>(R.id.ivGambarMenu))
            itemView.findViewById<ImageView>(R.id.ivGambarMenu)
            itemView.findViewById<TextView>(R.id.tvNamaTambah).text = menu?.menu
            itemView.findViewById<TextView>(R.id.tvHargaTambah).text = menu?.harga.toString()
            itemView.findViewById<Button>(R.id.btTambahTambah).setOnClickListener {
                onItemCallBackListener?.tambah(menu!!)
            }
        }
    }

    fun tambahClicked(onTap: (menu: Menu) -> Unit) {
        onItemCallBackListener = object : OnItemCallBackListener {
            override fun tambah(menu: Menu) {
                onTap(menu)
            }
        }
    }

    interface OnItemCallBackListener {
        fun tambah(menu: Menu)
    }

}