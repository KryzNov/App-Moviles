package com.example.mya.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mya.navigation.NavManager
import com.example.mya.ui.theme.MyATheme
import com.example.mya.viewModel.SearchViewModel

@Composable
fun LocalizacionScreen(viewModel: SearchViewModel) {
    MyATheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavManager(viewModel)
        }
    }
}