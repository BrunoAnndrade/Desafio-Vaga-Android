package com.example.desafiofenoxtec.Presentation.Ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.desafiofenoxtec.Presentation.NewsListViewModel
import com.example.desafiofenoxtec.Presentation.NewsRemoteState
import com.example.desafiofenoxtec.Presentation.Screen
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun NewsListCard(
    state: NewsRemoteState, viewModel: NewsListViewModel, navController: NavHostController

) {
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing)

    val newsListDataBase by viewModel.newsList.collectAsState()

    SwipeRefresh(state = swipeRefreshState, onRefresh = { viewModel.getNewsList() }) {

        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White)


        ) {

            Column {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)

                ) {

                    items(
                        newsListDataBase

                    ) { newsItem ->

                        Row(modifier = Modifier.clickable {

                            navController.navigate(Screen.Detail.createRoute(newsItem.id.toString()))
                        }) {

                            Column {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,

                                    ) {

                                    AsyncImage(
                                        model = newsItem.image,
                                        contentDescription = null,
                                        modifier = Modifier.size(100.dp)
                                    )

                                    Text(
                                        text = newsItem.titulo,
                                        color = Color.Black,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Justify,
                                        lineHeight = 18.sp,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }

                                Text(
                                    text = newsItem.introducao,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Black,
                                    textAlign = TextAlign.Justify,
                                )
                                Text(
                                    text = newsItem.data_publicacao,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Black,
                                    modifier = Modifier.padding(top = 5.dp),
                                    )


                            }

                        }


                    }
                }

            }

        }
    }


}


