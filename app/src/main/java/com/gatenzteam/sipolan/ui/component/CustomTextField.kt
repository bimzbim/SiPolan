package com.gatenzteam.sipolan.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = Poppins.poppinsFamily,
                    color = colorResource(R.color.color_palette4)
                ),
            )
        },
        singleLine = singleLine,
        readOnly = readOnly,
        enabled = enabled,
        textStyle = TextStyle(
            fontFamily = Poppins.poppinsFamily,
            fontSize = 14.83.sp,
            color = colorResource(id = R.color.color_palette3),
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontFamily = Poppins.poppinsFamily,
                    color = colorResource(R.color.color_palette4)
                ),
            )
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = colorResource(id = R.color.color_palette3),
            focusedLabelColor = colorResource(id = R.color.color_palette4),
            unfocusedLabelColor = colorResource(id = R.color.color_palette3),
            focusedTextColor = colorResource(id = R.color.color_palette4),
            focusedBorderColor = colorResource(id = R.color.color_palette3),
            unfocusedBorderColor = colorResource(id = R.color.color_palette2)
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
    )
}