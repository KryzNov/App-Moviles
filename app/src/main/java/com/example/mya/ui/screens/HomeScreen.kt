package com.example.mya.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Column {
        Text(text = "This is HomeScreen")
        Button(onClick = {navController.navigate("menu")} ) { }
        Button(onClick = {navController.navigate("components")} ) {
            Text ("go to components screen")
        }
    }
}