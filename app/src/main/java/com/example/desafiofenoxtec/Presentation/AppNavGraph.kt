package com.example.desafiofenoxtec.Presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.desafiofenoxtec.Presentation.Ui.NewsDetail
import com.example.desafiofenoxtec.Presentation.Ui.NewsListCard

@Composable
fun AppNavGraph(
    navController: NavHostController,
    state: NewsRemoteState
) {
    val viewModel: NewsListViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = navegationScreens.News.route
    ) {

        composable(
            route = navegationScreens.Detail.route,
            arguments = listOf(navArgument("newsId") { type = NavType.StringType })
        ) { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString("newsId")?.toIntOrNull()
            val newsItem = state.newsResponse?.items?.find { it.id == newsId }
            newsItem?.let {
                NewsDetail(state, navController, newsItem)
            }
        }

        composable(route = navegationScreens.News.route) {
            NewsListCard(state,viewModel, navController)
        }
    }

}