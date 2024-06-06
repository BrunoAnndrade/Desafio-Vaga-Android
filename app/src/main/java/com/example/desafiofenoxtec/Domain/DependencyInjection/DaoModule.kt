package com.example.desafiofenoxtec.Domain.DependencyInjection

import android.content.Context
import androidx.room.Room
import com.example.desafiofenoxtec.Data.Local.AppDataBase
import com.example.desafiofenoxtec.Data.Local.NewsEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideNewsDao(appDatabase: AppDataBase) = appDatabase.newsDao()

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "NEWS_DATABASE"
    ).build()

    @Provides
    fun provideEntity() = NewsEntity()
}