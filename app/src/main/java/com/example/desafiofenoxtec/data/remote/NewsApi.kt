package com.example.desafiofenoxtec.data.remote

import retrofit2.http.GET

interface NewsApi {
    @GET("noticias/?tipo=release?de=09-27-2023")
    suspend fun getNewsData():NewsResponse
}