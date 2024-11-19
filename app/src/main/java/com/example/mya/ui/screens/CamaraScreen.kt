package com.example.mya.ui.screens

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.mya.ui.camara.rememberCameraLauncher
import com.example.mya.ui.camara.rememberGalleryLauncher
import com.example.mya.ui.camara.rememberPermissionLauncher
import com.example.mya.ui.camara.requestPermissions
import com.example.mya.R

@Composable
fun CameraScreen() {
    val imageUris = remember { mutableStateListOf<Uri>() }

    // Conservamos el contexto local
    val context = LocalContext.current

    // Lanzadores de funcionalidad y permisos
    val permissionLauncher = rememberPermissionLauncher(context) { granted ->
        if (!granted) return@rememberPermissionLauncher
    }

    val cameraLauncher = rememberCameraLauncher(context) { uri ->
        uri?.let { imageUris.add(it) }
    }

    val galleryLauncher = rememberGalleryLauncher { uri ->
        uri?.let { imageUris.add(it) }
    }
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar las imágenes seleccionadas o tomadas
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(imageUris) { uri ->
                    Box(modifier = Modifier.padding(bottom = 10.dp)) {
                        // Obtener el bitmap de la URI utilizando BitmapFactory
                        val bitmap = BitmapFactory.decodeStream(context.contentResolver.openInputStream(uri))
                        bitmap?.let {
                            Image(
                                bitmap = it.asImageBitmap(),
                                contentDescription = "Imagen tomada o seleccionada",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        }

                        IconButton(
                            onClick = { imageUris.remove(uri) },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(36.dp)
                                .padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Eliminar imagen",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }

            // Botones para abrir la cámara o galería
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FloatingActionButton(
                    onClick = {
                        requestPermissions(context, permissionLauncher) {
                            cameraLauncher.launch(null)
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.a),  // Cargar la imagen desde los recursos
                        contentDescription = "Abrir cámara",
                        modifier = Modifier.size(36.dp)  // Tamaño del ícono, puedes ajustarlo según sea necesario
                    )
                }

                FloatingActionButton(
                    onClick = {
                        requestPermissions(context, permissionLauncher) {
                            galleryLauncher.launch("image/*")
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Importar Imagen"
                    )
                }

                FloatingActionButton(
                    onClick = { imageUris.clear() },
                    containerColor = MaterialTheme.colorScheme.error,
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Eliminar todas las imágenes"
                    )
                }
            }
        }
    }
}