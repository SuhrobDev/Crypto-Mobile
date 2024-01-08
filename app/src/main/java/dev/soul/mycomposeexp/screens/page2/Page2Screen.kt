package dev.soul.mycomposeexp.screens.page2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Page2Screen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)){
        Text(text = "page2")
    }
}