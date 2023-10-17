package com.example.appimobiliaria.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appimobiliaria.components.Botao
import com.example.appimobiliaria.components.NavContent
import com.example.appimobiliaria.ui.theme.azulClaro
import com.example.appimobiliaria.ui.theme.azulEscuro

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
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

                }
            )
        }
    ){
        ContentHomeScreen(navController)
    }
}

@Composable
fun ContentHomeScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(azulClaro)
        .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Botao(text = "Comprar", icon = Icons.Default.ShoppingCart){
            navController.navigate("comprar")
        }

        Spacer(modifier = Modifier.height(28.dp))

        Botao(text = "Alugar", icon = Icons.Default.Home){
            navController.navigate("comprar")
        }

        Spacer(modifier = Modifier.height(28.dp))


        Botao(text = "Novos", icon = Icons.Default.Add){
            navController.navigate("novo")
        }

        Spacer(modifier = Modifier.height(28.dp))


        Botao(text = "Anuncie no App", icon = Icons.Default.Edit){
            navController.navigate("Anunciar")
        }

        Spacer(modifier = Modifier.height(28.dp))


        Botao(text = "Nosso time", icon = Icons.Default.AccountCircle){
            navController.navigate("sobre")
        }

        Spacer(modifier = Modifier.height(28.dp))

        Botao(text = "Sobre nós", icon = Icons.Default.Person){
            navController.navigate("SobreNos")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    val navController = rememberNavController()
    HomeScreen(navController)
}