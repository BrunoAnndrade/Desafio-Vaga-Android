package com.example.desafiofenoxtec.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiofenoxtec.data.repository.DataBaseRepository
import com.example.desafiofenoxtec.data.local.NewsEntity
import com.example.desafiofenoxtec.data.repository.NewsApiRepository
import com.example.desafiofenoxtec.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: NewsApiRepository,
    private val dataBaseRepository: DataBaseRepository
) : ViewModel() {

    private val _newsList = MutableStateFlow<List<NewsEntity>>(emptyList())
    val newsList: StateFlow<List<NewsEntity>> = _newsList.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    var state by mutableStateOf(NewsRemoteState())
        private set
    init {
        viewModelScope.launch {
            loadNewsFromDatabase()
            getNewsList()
        }
    }

    private suspend fun loadNewsFromDatabase() {
        dataBaseRepository.getAllNews().collect { itemList ->
            _newsList.value = itemList
        }
    }
    fun getNewsList() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = repository.getNewsData()) {
                is Resource.Success -> {

                    val newsItems = result.data?.items

                    val newsEntities = newsItems?.map { newsItem ->
                        NewsEntity(
                            id = newsItem.id,
                            introducao = newsItem.introducao,
                            titulo = newsItem.titulo,
                            data_publicacao = newsItem.data_publicacao,
                            image = newsItem.getImageUrl()
                        )
                    }

                    if (newsEntities != null) {
                        saveNewsToDataBase(newsEntities)
                    }

                    state = state.copy(
                        newsResponse = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        newsResponse = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    private suspend fun saveNewsToDataBase(newsList:List<NewsEntity>){
        dataBaseRepository.saveNews(newsList)
        dataBaseRepository.updateNews((newsList))
    }
}