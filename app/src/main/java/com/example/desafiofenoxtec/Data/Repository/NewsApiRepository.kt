package com.example.desafiofenoxtec.Data.Repository

import com.example.desafiofenoxtec.Data.Remote.NewsResponse
import com.example.desafiofenoxtec.Domain.Util.Resource

/* Interface for accessing News data from a remote data source.
 The method is suspending and returns a Resource object encapsulating the result.
 The Resource object contains either a NewsResponse on success or an error message on failure.
 */

interface NewsApiRepository {
    suspend fun getNewsData(): Resource<NewsResponse>
}