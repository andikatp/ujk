import com.google.gson.annotations.SerializedName

data class PesananResult(
    @field:SerializedName("pesanan")
    val pesanan: List<Pesanan?>? = null
)