package com.example.desafiofenoxtec.Data.Local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity ORDER BY id DESC")
    fun getAllNews(): Flow<List<NewsEntity>>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNews(newsList: List<NewsEntity>)

    @Query("DELETE FROM NewsEntity")
    suspend fun clearAllNews()



    @Update
    suspend fun updateNews(newsEntity: List<NewsEntity>)
}