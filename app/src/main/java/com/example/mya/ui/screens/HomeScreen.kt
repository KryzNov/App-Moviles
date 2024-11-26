package com.example.mya.ui.screens

import com.example.mya.data.model.ServiceModel
import com.example.mya.ui.components.ServiceCard
import com.example.mya.ui.components.TopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.mya.R
import com.example.mya.data.model.controller.ServiceViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: ServiceViewModel=androidx.lifecycle.viewmodel.compose.viewModel()){
    /*Column{
        Text(text="This is the HomeScreen")
        Button(onClick = { navController.navigate("menu")}) {
        }
        Button(onClick = { navController.navigate("components")}) {
        }
    }*/

    var serviceDetail by remember {
        mutableStateOf<ServiceModel?>(null)
    }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar ={ TopBar(title = "Password Manager", navController = navController, backButton = false)},
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black,
                contentColor = Color.White
            ){
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                containerColor = colorResource(id = R.color.teal_700),
                contentColor = Color.Black,
                onClick = { navController.navigate("manage-service/0") }
            ) {
                Icon(Icons.Filled.Add,contentDescription="Add")
            }
        }
    ){ innerPadding ->
        // BottomSheet Content
        var services by remember{ mutableStateOf<List<ServiceModel>>(emptyList()) }
        if(services.isEmpty()){
            CircularProgressIndicator()
        }

        //Executes the first time only
        LaunchedEffect(Unit) {
            viewModel.getServices{ response->
                if(response.isSuccessful){
                    services = response.body() ?: emptyList()
                }else{
                    println("Failed to load posts")
                }
            }
        }

        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.black))
                .fillMaxSize(),
            state = listState
        ){
            items(services){ service ->
                ServiceCard(
                    id = service.id,
                    name = service.name,
                    username = service.username,
                    imageUrl = service.imageURL, // Cambiar 'imageURL' a 'imageUrl'
                    onButtonClick = {
                        viewModel.showServices(service.id) { response ->
                            if (response.isSuccessful) {
                                serviceDetail = response.body()
                            }
                        }
                        showBottomSheet = true
                    }
                )
            }
        }

        if(showBottomSheet){

        }

    }
}