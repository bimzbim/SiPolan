package com.gatenzteam.sipolan.ui.component

import android.widget.Button
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun CustomFilterButton(
    onClick: () -> Unit,
    isFilterActive: Boolean,
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    var buttonColorPref : ButtonColors
    if(isFilterActive){
        buttonColorPref = ButtonDefaults.buttonColors(
            containerColor = ColorPalette2,
            contentColor = ColorPalette3
        )
    } else {
        buttonColorPref = ButtonDefaults.buttonColors(
            containerColor = ColorPalette1,
            contentColor = ColorPalette4
        )
    }
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = buttonColorPref,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(10.dp)
                .size(30.dp)
        )
    }
}