package com.example.appimobiliaria.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appimobiliaria.R
import com.example.appimobiliaria.components.Botao
import com.example.appimobiliaria.components.NavContent
import com.example.appimobiliaria.components.Voltar
import com.example.appimobiliaria.ui.theme.azulEscuro

@SuppressLint("UnusedMaterial33ScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnunciarScreen(navController: NavController){
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
        ContentAnunciarScreen(navController)
    }
}

@Composable
fun ContentAnunciarScreen(navController: NavController){
    Column (
        Modifier
            .padding(start = 30.dp, top = 80.dp, end = 30.dp, bottom = 0.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                Modifier.width(400.dp)
            )
            Spacer(Modifier.height(20.dp))
        }

        Row (){
            Column(){
                Text(
                    text = "Cadastre seu imóvel",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Envie-nos seus contatos e os dados do imóvel para anunciar no app"
                )

                Spacer(Modifier.height(50.dp))

                //SELECT tipo de imóvel
                SelectDropdown(
                    arrayOf("Casa", "Apartamento", "Chácara", "Comercial"),
                    "Tipo de imóvel"
                )

                //SELECT Disponível para
                SelectDropdown(
                    arrayOf("Locação", "Venda", "Locação e venda"),
                    "Disponível para"
                )

                //SELECT Preço de venda
                MyOutlinedTextField("Preço de venda")

                //SELECT Endereço do imóvel
                MyOutlinedTextField("Endereço do imóvel")

                //SELECT Valor do aluguel
                MyOutlinedTextField("Valor do aluguel")

                //SELECT Descrição do imóvel
                MyOutlinedTextField("Descrição do imóvel")

                //SELECT Email
                MyOutlinedTextField("Email")

                //SELECT Telefone
                MyOutlinedTextField("Telefone")


                Text(
                    text = "Foto 1",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
                )

                Botao("Escolher Arquivo", Icons.Default.List, {  })


                Text(
                    text = "Foto 2",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
                )

                Botao("Escolher Arquivo", Icons.Default.List, {  })

                Text(
                    text = "Foto 3",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
                )

                Botao("Escolher Arquivo", Icons.Default.List, {  })

                Botao("Enviar", Icons.Default.List, {  })

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDropdown(items: Array<String>, title: String) {
    val context = LocalContext.current
    // val items = arrayOf("Casa", "Apartamento", "Chácara", "Comercial")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(title) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Red, // Cor da borda quando o campo está focado
                    unfocusedBorderColor = Color.Gray, // Cor da borda quando o campo não está focado
                    cursorColor = Color.Black // Cor do cursor
                ),

                )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(Color.White) // E aqui
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item, color = Color.Black) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            //Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedTextField(label: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red, // Cor da borda quando o campo está focado
            unfocusedBorderColor = Color.Gray, // Cor da borda quando o campo não está focado
            cursorColor = Color.Black // Cor do cursor
        ),

        )
}

@Preview(showBackground = true)
@Composable
fun AnunciePreview(){
    val navController = rememberNavController()
    AnunciarScreen(navController)
}