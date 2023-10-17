package com.example.appimobiliaria.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appimobiliaria.R
import com.example.appimobiliaria.components.CardImagensTime
import com.example.appimobiliaria.components.NavContent
import com.example.appimobiliaria.components.Voltar
import com.example.appimobiliaria.ui.theme.azulEscuro

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreNosScreen(navController: NavController){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    NavContent()
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = azulEscuro
                ),
                navigationIcon = {
                    Voltar(){
                        navController.navigate("home")
                    }
                }
            )
        }
    ){
        ContentSobreNosScreen(navController)
    }
}

@Composable
fun ContentSobreNosScreen(navController: NavController){
    Row (
        modifier = Modifier.fillMaxSize()
            .padding(top = 80.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        CardImagensTime(
            "Sarah Jandozza Laurindo - Corretor(a)",
            painterResource(R.drawable.sarah)
        )

        CardImagensTime(
            "Marcia Silva Santos - Corretor(a)",
            painterResource(R.drawable.corretor)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SobreNosPreview(){
    val navController = rememberNavController()
    SobreNosScreen(navController)
}