package com.example.desafiofenoxtec.Data.Repository

import com.example.desafiofenoxtec.Data.Local.NewsDao
import com.example.desafiofenoxtec.Data.Local.NewsEntity
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val dao: NewsDao
) {

    suspend fun saveNews(news:List<NewsEntity>) = dao.insertAllNews(news)
    suspend fun updateNews(news:List<NewsEntity>) = dao.updateNews(news)

    fun getAllNews() = dao.getAllNews()

}