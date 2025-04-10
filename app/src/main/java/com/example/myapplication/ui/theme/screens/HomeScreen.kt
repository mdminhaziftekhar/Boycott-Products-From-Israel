package com.example.myapplication.ui.theme.screens
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {navController.navigate("products")}
            ) {
                Text(text = "+", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) { padding ->
        Text("Welcome to the Home Page", modifier = Modifier.padding(padding) )
    }
}
