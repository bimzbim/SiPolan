package com.gatenzteam.sipolan.ui.screen.metode_bayar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gatenzteam.sipolan.ui.theme.colorpalette1
import com.gatenzteam.sipolan.ui.theme.colorpalette4

@Composable
fun MetodeBayarScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(colorpalette1)
    ){
        Text(text = "Metode Bayar", color = colorpalette4)
    }
}