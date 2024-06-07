package com.example.desafiofenoxtec.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.desafiofenoxtec.presentation.screens.NewsDetail
import com.example.desafiofenoxtec.presentation.screens.NewsListCard

@Composable
fun AppNavGraph(
    navController: NavHostController,
    state: NewsRemoteState
) {
    val viewModel: NewsListViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = NavScreens.News.route
    ) {

        composable(
            route = NavScreens.Detail.route,
            arguments = listOf(navArgument("newsId") { type = NavType.StringType })
        ) { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString("newsId")?.toIntOrNull()
            val newsItem = state.newsResponse?.items?.find { it.id == newsId }
            newsItem?.let {
                NewsDetail( newsItem,viewModel)
            }
        }

        composable(route = NavScreens.News.route) {
            NewsListCard(state,viewModel, navController)
        }
    }

}