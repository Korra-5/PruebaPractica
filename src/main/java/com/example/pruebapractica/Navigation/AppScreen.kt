package com.example.pruebapractica.Navigation

sealed class AppScreen (val route:String) {
    object PedirScreen:AppScreen("PedirScreen")
    object MostrarScreen:AppScreen("MostrarScreen")
}