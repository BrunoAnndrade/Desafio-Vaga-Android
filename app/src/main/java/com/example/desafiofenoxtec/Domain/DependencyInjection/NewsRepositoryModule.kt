package com.example.desafiofenoxtec.Domain.DependencyInjection

import com.example.desafiofenoxtec.Data.Repository.NewsApiRepository
import com.example.desafiofenoxtec.Data.Repository.NewsRepositoryImplemetation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class NewsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        newsRepositoryImplemetation: NewsRepositoryImplemetation
    ): NewsApiRepository

}