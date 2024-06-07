package com.example.desafiofenoxtec.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.desafiofenoxtec.presentation.AppNavGraph
import com.example.desafiofenoxtec.presentation.NewsListViewModel

import com.example.desafiofenoxtec.ui.theme.DesafioFenoxTecTheme
import com.example.desafiofenoxtec.ui.theme.brown
import com.example.desafiofenoxtec.ui.theme.pink_300
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val newsListViewModel: NewsListViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

       newsListViewModel.getNewsList()
        
        setContent {
            val navController = rememberNavController()

            DesafioFenoxTecTheme {

                Scaffold(

                    topBar = {

                        Surface(
                            shape = RoundedCornerShape(bottomEnd =5.dp, bottomStart = 5.dp)
                        ) {
                            TopAppBar(
                                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = pink_300),

                                title = {
                                    Text(
                                        text = "News",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = brown,
                                    )
                                }
                            )
                        }
                    },

                    ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)

                    ) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                                .clip(RoundedCornerShape(10.dp)),

                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            AppNavGraph(navController = navController, state = newsListViewModel.state)
                        }

                        if (newsListViewModel.state.isLoading){
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}

