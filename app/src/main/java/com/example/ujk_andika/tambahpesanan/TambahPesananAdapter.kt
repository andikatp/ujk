package com.example.ujk_andika.tambahpesanan

import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R
import com.example.ujk_andika.model.MenuCafe
import com.squareup.picasso.Picasso


class TambahPesananAdapter(val menu: List<MenuCafe?>?): RecyclerView.Adapter<TambahPesananAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_tambah_pesanan,parent,false)

        return MyHolder(v)
    }

    override fun getItemCount(): Int = menu?.size?:0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Log.d("adapter", menu.toString())
        holder.bind(menu?.get(position))


    }

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(menu: MenuCafe?){
            Picasso.get().load("http://172.10.10.90" + java.net.URLDecoder.decode(menu?.foto)).into(itemView.findViewById<ImageView>(R.id.ivGambarMenu))
            itemView.findViewById<ImageView>(R.id.ivGambarMenu)
            itemView.findViewById<TextView>(R.id.tvNamaTambah).text = menu?.menu
            itemView.findViewById<TextView>(R.id.tvHargaTambah).text = menu?.harga.toString()

            itemView.findViewById<Button>(R.id.btTambahTambah).setOnClickListener {

            }
        }
    }


}