import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pesanan(
    @field:SerializedName("id_pesanan")
    val idPesanan: Int? = null,

    @field:SerializedName("harga")
    val harga: Int? = null,

    @field:SerializedName("foto")
    val foto: String? = null,

    @field:SerializedName("no_meja")
    val noMeja: String? = null,

    @field:SerializedName("kategori")
    val kategori: String? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("menu")
    val menu: String? = null,

    @field:SerializedName("waktu")
    val waktu: String? = null
):Parcelable