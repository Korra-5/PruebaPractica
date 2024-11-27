package com.example.pruebapractica.Scenes

import android.R.string
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pruebapractica.Navigation.AppScreen


@Composable
fun AppMostrarDatos(navControlador: NavHostController, it1: String) {

    //Se reparten las diferentes  variables
    val datos: List<String> = it1.split(",")
    var nombre = datos[0]
    var apellidos = datos[1]
    var dni = datos[2]

    //Comrpobacion de nulos, en el caso del apellido he permitido que sean nulos
    if (nombre==""){
    nombre="No ha introducido nombre"
        apellidos=""
    }

    if (dni.length!=8) {
        dni="No ha introducido DNI o este no \n se encuentra en un formato correcto"
    } else {
        //Se transforma a Int en caso de que la verificación sea correcta
        dni.toInt()
    }



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Icono que te lleva a la pagina principal
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Icono de vuelta atras",
                modifier = Modifier
                    .width(100.dp)
                    .padding(30.dp,30.dp,5.dp,30.dp)
                    .clickable { navControlador.navigate(route = AppScreen.PedirScreen.route) }
                , tint = Color.Black
            )
            Text("Ir atras")
        }

        //Column en la que se escribe
        Column(
            modifier = Modifier.align(Alignment.Center).width(320.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text="¡Bienvenido!", Modifier.background(Color.White), color = Color.Black, style = TextStyle(fontSize = 35.sp))
            Spacer(Modifier.height(35.dp))
            Text(text="Tu nombre es: $nombre $apellidos", Modifier.background(Color.White), color = Color.Black, style = TextStyle(fontSize = 16.sp))
            Spacer(Modifier.height(35.dp))
            Text(text="Y tu DNI es: $dni", Modifier.background(Color.White), color = Color.Black, style = TextStyle(fontSize = 16.sp))

        }
    }
}