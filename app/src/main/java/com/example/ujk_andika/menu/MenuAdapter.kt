import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ujk_andika.R
import com.example.ujk_andika.model.Menu
import com.squareup.picasso.Picasso


class MenuAdapter(val menu: List<Menu?>?): RecyclerView.Adapter<MenuAdapter.MyHolder>(){
    private var onItemCallBackListener: OnItemCallBackListener? = null
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){



        fun bind(menu: Menu?){
            Picasso.get().load("http://172.10.10.90" + java.net.URLDecoder.decode(menu?.foto)).into(itemView.findViewById<ImageView>(R.id.gambarMenu))
            itemView.findViewById<TextView>(R.id.judulMenu).text =menu?.menu.toString().uppercase()

            itemView.setOnClickListener {
                onItemCallBackListener?.move(menu!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_detail, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
       return menu?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.bind(menu?.get(position))
    }


    fun detailMenuClicked(onTap: (menu: Menu) -> Unit){
        onItemCallBackListener = object : OnItemCallBackListener{
            override fun move(menu: Menu) {
                onTap(menu)
            }

        }

    }
    interface OnItemCallBackListener{
        fun move(menu: Menu)
    }

}