package com.example.desafiofenoxtec.Presentation.Ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.desafiofenoxtec.Data.Remote.NewsResponse
import com.example.desafiofenoxtec.Presentation.NewsRemoteState

@Composable
fun NewsDetail(
    state: NewsRemoteState,
    navController: NavHostController,
    newsResponse: NewsResponse.NewsItem
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        Text(
            text = newsResponse.titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,

        )


        AsyncImage(
            model = newsResponse.getImageUrl(),
            contentDescription = null,
            modifier = Modifier.size(200.dp).align(Alignment.CenterHorizontally)

        )
        Text(
            text = newsResponse.introducao,

            fontSize = 15.sp,
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,

            )

        Text(
            text = newsResponse.data_publicacao,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            lineHeight = 18.sp,


            )


    }


}
