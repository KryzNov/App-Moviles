package com.example.mya.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.composable

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Menu Screen")
        Button(onClick = { navController.navigate("component") }) {
            Text("Go to Home")

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Api Segundo Plano")
        Button(onClick = { navController.navigate("SegundoPlano") }) {
            Text("Go to alarm")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Api Geolocalizacion")
        Button(onClick = { navController.navigate("Location") }) {
            Text("Go to location")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Api Calendario")
        Button(onClick = { navController.navigate("ContactCalendar") }) {
            Text("Contact and Calendar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Api de Biometricos")
        Button(onClick = {navController.navigate("BiometricsScreen")}) {
            Text("Go to Biometrics")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Api Camara")
        Button(onClick = { navController.navigate("CamaraScreen") }) {
            Text("Camera and files")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Api de Conexion")
        Button(onClick = {navController.navigate("wifidatos")}) {
            Text("Go to Wifi-Datos")
        }

    }
}