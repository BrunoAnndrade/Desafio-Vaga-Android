package com.example.desafiofenoxtec.data.repository

import com.example.desafiofenoxtec.data.local.NewsDao
import com.example.desafiofenoxtec.data.local.NewsEntity
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val dao: NewsDao
) {
    suspend fun saveNews(news:List<NewsEntity>) = dao.insertAllNews(news)
    suspend fun updateNews(news:List<NewsEntity>) = dao.updateNews(news)
    fun getAllNews() = dao.getAllNews()

}