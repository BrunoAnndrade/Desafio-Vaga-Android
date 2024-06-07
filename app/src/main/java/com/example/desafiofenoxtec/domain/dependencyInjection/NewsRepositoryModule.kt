package com.example.desafiofenoxtec.domain.dependencyInjection

import com.example.desafiofenoxtec.data.repository.NewsApiRepository
import com.example.desafiofenoxtec.data.repository.NewsRepositoryImplemetation
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