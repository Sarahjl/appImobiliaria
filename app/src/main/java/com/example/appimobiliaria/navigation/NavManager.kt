package com.example.appimobiliaria.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appimobiliaria.views.AnunciarScreen
import com.example.appimobiliaria.views.ComprarScreen
import com.example.appimobiliaria.views.HomeScreen
import com.example.appimobiliaria.views.NovoScreen
import com.example.appimobiliaria.views.SobreNosScreen

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeScreen(navController)
        }

        composable("Comprar"){
            ComprarScreen(navController)
        }

        composable("Novo"){
            NovoScreen(navController)
        }

        composable("Anunciar"){
            AnunciarScreen(navController)
        }

        composable("SobreNos"){
            SobreNosScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    val navController = rememberNavController()
    HomeScreen(navController)
}