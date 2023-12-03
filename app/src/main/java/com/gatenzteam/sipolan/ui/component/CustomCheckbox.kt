package com.gatenzteam.sipolan.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins

@Composable
fun CustomCheckbox(
    modifier: Modifier = Modifier,
    value: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 30.dp)
    ){
        Checkbox(
            checked = value,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkmarkColor = colorResource(id = R.color.color_palette2),
                checkedColor = colorResource(id = R.color.color_palette3),
                uncheckedColor = colorResource(id = R.color.color_palette4)
            )
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.83.sp,
                fontFamily = Poppins.poppinsFamily,
                color = colorResource(R.color.color_palette4),
            ),
        )
    }
}