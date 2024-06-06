package com.example.desafiofenoxtec.Presentation.Ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.desafiofenoxtec.Presentation.AppNavGraph
import com.example.desafiofenoxtec.Presentation.NewsListViewModel

import com.example.desafiofenoxtec.ui.theme.DesafioFenoxTecTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val newsListViewModel: NewsListViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>


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
                        TopAppBar(

                            colors = TopAppBarDefaults.mediumTopAppBarColors(
                                containerColor = Color.Black
                            ), title = {
                                Text(
                                    text = "News List",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                )
                            })
                    },

                    ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)


                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxSize()

                                ,


                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Call your custom NavGraph composable
                            AppNavGraph(navController = navController, state = newsListViewModel.state)

                        }

                    }
                }
            }
        }
    }

}

