package com.example.desafiofenoxtec.presentation

sealed class NavScreens(val route: String) {
    data object News : NavScreens("newsList")
    data object Detail : NavScreens("newsDetail/{newsId}"){
        fun createRoute(newsId: String) = "newsDetail/$newsId"
    }

}