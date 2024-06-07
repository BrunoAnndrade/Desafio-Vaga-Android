package com.example.desafiofenoxtec.presentation

import com.example.desafiofenoxtec.data.remote.NewsResponse

data class NewsRemoteState(
    val newsResponse:NewsResponse? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
