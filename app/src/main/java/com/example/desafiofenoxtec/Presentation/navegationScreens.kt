package com.example.desafiofenoxtec.Presentation

sealed class navegationScreens(val route: String) {
    data object News : navegationScreens("newsList")
    data object Detail : navegationScreens("newsDetail/{newsId}"){
        fun createRoute(newsId: String) = "newsDetail/$newsId"
    }

}