package com.gatenzteam.sipolan.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3

@Composable
fun CustomIconButton(
    onClick: () -> Unit,
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(ColorPalette3),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = ColorPalette1,
            modifier = Modifier
                .padding(end = 10.dp)
        )
        Text(text = text,
            fontSize = 14.83.sp,
            fontFamily = Poppins.poppinsFamily,
            color = ColorPalette1
        )
    }
}