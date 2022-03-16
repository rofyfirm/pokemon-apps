package id.rofyfirm.pokemonapps.network.response

import com.google.gson.annotations.SerializedName

class MainResponse {
    @SerializedName("count") var count: Int? = null
    @SerializedName("next") var next: String? = null
    @SerializedName("previous") var previous: String? = null
    @SerializedName("results") var results: ArrayList<Results>? = null

    data class Results(
        @SerializedName("name") var name : String? = null,
        @SerializedName("url") var url  : String? = null
    )
}