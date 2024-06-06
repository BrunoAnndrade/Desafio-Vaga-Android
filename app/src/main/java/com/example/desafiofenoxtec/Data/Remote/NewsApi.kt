package com.example.desafiofenoxtec.Data.Remote

import retrofit2.http.GET

interface NewsApi {

    // BASE URL: http://servicodados.ibge.gov.br/api/v3/noticias/

    @GET("noticias/?tipo=release?de=09-27-2023")
    suspend fun getNewsData():NewsResponse
}