package com.gatenzteam.sipolan.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String,
    labelColor: Color = ColorPalette3,
    placeholder: String,
    placeholderColor: Color = ColorPalette3,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true,
    color: TextFieldColors = OutlinedTextFieldDefaults.colors(
        cursorColor = ColorPalette3,
        focusedLabelColor = ColorPalette4,
        unfocusedLabelColor = ColorPalette4,
        focusedTextColor = ColorPalette4,
        focusedBorderColor = ColorPalette3,
        unfocusedBorderColor = ColorPalette2
    ),
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            CustomText(
                text = placeholder,
            )
        },
        singleLine = singleLine,
        readOnly = readOnly,
        enabled = enabled,
        textStyle = TextStyle(
            fontFamily = Poppins.poppinsFamily,
            fontSize = 14.83.sp,
            color = ColorPalette4,
        ),
        placeholder = {
            CustomText(
                text = placeholder,
                color = placeholderColor,
            )
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = color,
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
    )
}