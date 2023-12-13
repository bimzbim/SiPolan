package com.gatenzteam.sipolan.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun CustomDetailText(
    typeInfo: String,
    dataInfo: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        CustomText(
            text = typeInfo,
            fontSize = 13.sp,
            color = ColorPalette4
        )
        CustomText(
            text = dataInfo,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.End,
            color = ColorPalette4
        )
    }
}