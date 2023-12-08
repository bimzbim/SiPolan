package com.gatenzteam.sipolan.ui.screen.deteksi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun DeteksiScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(ColorPalette1)
    ){
        Text(text = "Deteksi", color = ColorPalette4)
    }
}