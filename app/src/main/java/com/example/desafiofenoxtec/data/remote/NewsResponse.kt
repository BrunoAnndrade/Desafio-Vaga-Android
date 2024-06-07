package com.example.desafiofenoxtec.data.remote

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class NewsResponse(
    val items: List<NewsItem>
) {
    @Parcelize
    data class NewsItem(
        val id: Int,
        val tipo: String,
        val titulo: String,
        val introducao: String,
        val data_publicacao: String,
        val imagens: String,
        val link: String
    ) : Parcelable {
        fun getImageUrl(): String {
            val imagem = Gson().fromJson(imagens, Imagem::class.java)
            return "https://agenciadenoticias.ibge.gov.br/${imagem?.imageIntro}"
        }
    }
    data class Imagem(
        @SerializedName("image_intro") val imageIntro: String,
        @SerializedName("image_fulltext") val imageFulltext: String
    )
}





