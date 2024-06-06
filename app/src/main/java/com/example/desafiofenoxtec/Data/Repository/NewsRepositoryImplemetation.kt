package com.example.desafiofenoxtec.Data.Repository

import com.example.desafiofenoxtec.Data.Remote.NewsApi
import com.example.desafiofenoxtec.Data.Remote.NewsResponse
import com.example.desafiofenoxtec.Domain.Util.Resource
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