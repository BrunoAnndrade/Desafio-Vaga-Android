package com.example.desafiofenoxtec.Presentation

import com.example.desafiofenoxtec.Data.Remote.NewsResponse

data class NewsRemoteState(
    val newsResponse:NewsResponse? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
