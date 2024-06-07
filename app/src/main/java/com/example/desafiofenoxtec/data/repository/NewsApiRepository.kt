package com.example.desafiofenoxtec.data.repository

import com.example.desafiofenoxtec.data.remote.NewsResponse
import com.example.desafiofenoxtec.domain.util.Resource

interface NewsApiRepository {
    suspend fun getNewsData(): Resource<NewsResponse>
}