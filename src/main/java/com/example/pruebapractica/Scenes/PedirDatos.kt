package com.example.pruebapractica.Scenes

import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pruebapractica.Navigation.AppScreen
import com.example.pruebapractica.R

@Composable
fun AppPedirDatos(navController: NavHostController) {

    //Variables que guardan los TextFields
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }

    //Variable que se envia por el Nav
    var datos:String= nombre+","+apellido+","+dni

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="Introduzca sus datos:",  style = TextStyle(fontSize = 30.sp))

            Spacer(Modifier.height(30.dp))

            //Se hace la comprobacion de que el nombre no sea superior a 20 caracteres
            TextField(
                value = nombre,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.length <= 20) {
                        nombre = nuevoTexto
                    }
                },                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(Color.White),
                label = { Text("Nombre") },

                singleLine = true
            )

            Spacer(Modifier.height(16.dp))

            //Se hace la comprobacion de que los apellidos no sean superiores a 30 caracteres
            TextField(
                value = apellido,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.length <= 30) {
                        apellido = nuevoTexto
                    }
                },                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(Color.White),
                label = { Text("Apellidos") },
                singleLine = true
            )

            Spacer(Modifier.height(16.dp))


            //Se hace la comprobacion de que el DNI este compuesto de digitos y sean unicamente 8 numeros
            TextField(
                value = dni,
                onValueChange = { nuevoTexto ->
                    if (nuevoTexto.all { it.isDigit() } && nuevoTexto.length <= 8) {
                        dni = nuevoTexto
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(Color.White),
                label = { Text("DNI (Sin letra)") },
                singleLine = true
            )

            Spacer(Modifier.height(25.dp))

            //Boton que cambia de pantalla y envia datos
            Button(
                modifier = Modifier
                    .height(75.dp)
                    .width(150.dp)
                    .padding(top = 16.dp),
                onClick = {
                    navController.navigate(route = AppScreen.MostrarScreen.route + "/$datos")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = (colorResource(R.color.orange)),
                    contentColor = Color.White
                )            ) {
                Text("Acceder")
            }
        }
    }

}

