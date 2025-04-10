package com.example.myapplication.ui.theme.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

import com.example.myapplication.data.model.Product
import com.example.myapplication.data.network.RetrofitInstance

import kotlinx.coroutines.launch

@Composable
fun ProductsScreen() {
    val coroutineScope = rememberCoroutineScope()
    var productList by remember { mutableStateOf<List<Product>>(emptyList()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts()
                productList = response.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(productList) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(product.attributes.title, style = MaterialTheme.typography.titleMedium)
                    Image(
                        painter = rememberAsyncImagePainter(product.attributes.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Text("Price: \$${product.attributes.price}")
                }
            }
        }
    }
}
