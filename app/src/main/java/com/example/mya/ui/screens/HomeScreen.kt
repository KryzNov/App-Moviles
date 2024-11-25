package com.example.mya.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mya.data.model.ServiceModel
import com.example.mya.data.model.controller.ServiceViewModel
import com.example.mya.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: ServiceViewModel= viewModel()){
    val serviceDetail by remember { mutableStateOf<ServiceModel?>(null)}
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {TopBar("password Manager", navController, false)},
        bottomBar = {
            BottomAppBar(
                //containerColor= Color.Black,
                contentColor = Color.White
                
            ) {  }
        }
    ){  }
    Column {
        Text(text = "This is HomeScreen")
        Button(onClick = {navController.navigate("menu")} ) { }
        Button(onClick = {navController.navigate("components")} ) {
            Text ("go to components screen")
        }
    }
}