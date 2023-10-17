package com.example.appimobiliaria.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.twotone.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.appimobiliaria.ui.theme.azulEscuro
import com.example.appimobiliaria.views.HomeScreen
import com.example.appimobiliaria.views.NovoScreen

@Composable
fun Botao(text: String, icon: ImageVector, onClick:() -> Unit) {
    TextButton(
        onClick = onClick,
        border = BorderStroke(0.dp, azulEscuro),
        modifier = Modifier
            .border(1.dp, Color.White)
            .width(300.dp)
            .height(80.dp)
            .background(
                color = azulEscuro,
            )

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
            )

            Text(
                text = text,
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }
}

@Composable
fun Botao2(text: String, icon: ImageVector, onClick:() -> Unit){
    TextButton(
        onClick = onClick,
        border = BorderStroke(0.dp, Color.White),
        modifier = Modifier
            //.border(1.dp, Color.White, MaterialTheme.shapes.extraLarge)
            .width(315.dp)
            .height(80.dp)
            .background(
                Color.White,
                shape = RoundedCornerShape(50.dp)
            ),

        ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = text,
                color = azulEscuro,
                fontSize = 35.sp
            )

            Icon(
                imageVector = icon,
                contentDescription = "Icono",
                tint = azulEscuro,
                modifier = Modifier
                    .size(40.dp)
            )
        }
    }
}


@Composable
fun Voltar(onClick:() -> Unit){
    TextButton(onClick = onClick)
    {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Icono",
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBotoes(){
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(azulEscuro)
    ) {
        Botao("Bem-Vindo! ", Icons.TwoTone.FavoriteBorder){
            navController.navigate("comprar")
        }

        Spacer(modifier = Modifier.height(40.dp))

        Botao2("Bem-Vindo! ", Icons.Default.KeyboardArrowRight){
            navController.navigate("comprar")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun NovoPreview(){
    val navController = rememberNavController()
    NovoScreen(navController = navController)
}