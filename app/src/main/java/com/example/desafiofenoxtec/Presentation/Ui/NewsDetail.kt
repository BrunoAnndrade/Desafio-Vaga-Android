package com.example.desafiofenoxtec.Presentation.Ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.desafiofenoxtec.ui.theme.brown
import com.example.desafiofenoxtec.ui.theme.brown_2
import com.example.desafiofenoxtec.ui.theme.pink_100

@Composable
fun NewsDetail(
    state: NewsRemoteState,
    navController: NavHostController,
    newsResponse: NewsResponse.NewsItem
) {

    Column(
        modifier = Modifier
            .background(color = pink_100)
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),

    ) {
        Text(
            text = newsResponse.titulo,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = brown,
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
        )

        AsyncImage(
            model = newsResponse.getImageUrl(),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = newsResponse.introducao,
            fontSize = 15.sp,
            color = brown_2,
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )

        Text(
            text = newsResponse.data_publicacao,
            fontSize = 15.sp,
            color = brown_2,
            textAlign = TextAlign.Start,
            lineHeight = 18.sp,
            modifier = Modifier.padding(top=10.dp, start = 10.dp, bottom = 10.dp)
        )
    }
}
