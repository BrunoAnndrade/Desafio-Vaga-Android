package com.example.desafiofenoxtec.Presentation

sealed class Screen(val route: String) {
    object News : Screen("newsList")
    object Detail : Screen("newsDetail/{newsId}"){
        fun createRoute(newsId: String) = "newsDetail/$newsId"
    }

}