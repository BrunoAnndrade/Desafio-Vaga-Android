package com.example.desafiofenoxtec.data.repository

import com.example.desafiofenoxtec.data.remote.NewsApi
import com.example.desafiofenoxtec.data.remote.NewsResponse
import com.example.desafiofenoxtec.domain.util.Resource
import javax.inject.Inject

class NewsRepositoryImplemetation @Inject constructor(
    private val api: NewsApi
): NewsApiRepository {

    override suspend fun getNewsData(): Resource<NewsResponse> {
        return try {
            Resource.Success(
                data = api.getNewsData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}