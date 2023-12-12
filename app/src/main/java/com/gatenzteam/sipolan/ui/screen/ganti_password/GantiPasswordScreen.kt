package com.gatenzteam.sipolan.ui.screen.ganti_password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1

@Composable
fun GantiPasswordScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPalette1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            EditPassSection(
                onClick = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }
    }
}

@Composable
fun EditPassSection(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    var password by rememberSaveable { mutableStateOf("") }
    var newpassword by rememberSaveable { mutableStateOf("") }
    var newpasswordconfirm by rememberSaveable { mutableStateOf("") }
    var visibilityPassword by rememberSaveable { mutableStateOf(false) }
    var visibilityNewPassword by rememberSaveable { mutableStateOf(false) }
    var visibilityConfirmPassword by rememberSaveable { mutableStateOf(false) }
    var passwordMismatchError by remember { mutableStateOf(false) }

    CustomTextField(
        value = password,
        onValueChange = { password = it },
        label = "Password Saat Ini",
        singleLine = true,
        placeholder = "Password Saat Ini",
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                tint = colorResource(R.color.color_palette3)
            )
        },
        visualTransformation = if (visibilityPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val icon = if (visibilityPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val contentDescription = if (visibilityPassword) "Sembunyikan Password" else "Tampilkan Password"
            val tintIcon = if (visibilityPassword) colorResource(R.color.color_palette3) else colorResource(R.color.color_palette4)

            IconButton(onClick = {visibilityPassword = !visibilityPassword}){
                Icon(
                    imageVector  = icon,
                    contentDescription = contentDescription,
                    tint = tintIcon
                )
            }
        },
        modifier = modifier.padding(bottom = 15.dp)
    )

    CustomTextField(
        value = newpassword,
        onValueChange = { newpassword = it },
        label = "Password Baru",
        singleLine = true,
        placeholder = "Password Baru",
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                tint = colorResource(R.color.color_palette3)
            )
        },
        visualTransformation = if (visibilityNewPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val icon = if (visibilityNewPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val contentDescription = if (visibilityNewPassword) "Sembunyikan Password" else "Tampilkan Password"
            val tintIcon = if (visibilityNewPassword) colorResource(R.color.color_palette3) else colorResource(R.color.color_palette4)

            IconButton(onClick = {visibilityNewPassword = !visibilityNewPassword}){
                Icon(
                    imageVector  = icon,
                    contentDescription = contentDescription,
                    tint = tintIcon
                )
            }
        },
        modifier = modifier.padding(bottom = 15.dp)
    )

    CustomTextField(
        value = newpasswordconfirm,
        onValueChange = { newpasswordconfirm = it },
        label = "Verifikasi Password Baru",
        singleLine = true,
        placeholder = "Ulang Password Baru",
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                tint = colorResource(R.color.color_palette3)
            )
        },
        visualTransformation = if (visibilityConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val icon = if (visibilityConfirmPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val contentDescription = if (visibilityConfirmPassword) "Sembunyikan Password" else "Tampilkan Password"
            val tintIcon = if (visibilityConfirmPassword) colorResource(R.color.color_palette3) else colorResource(R.color.color_palette4)

            IconButton(onClick = {visibilityConfirmPassword = !visibilityConfirmPassword}){
                Icon(
                    imageVector  = icon,
                    contentDescription = contentDescription,
                    tint = tintIcon
                )
            }
        },
        modifier = modifier.padding(bottom = 25.dp)
    )

    Button(
        onClick = {
            if (newpassword == newpasswordconfirm) {
                passwordMismatchError = false
                onClick()
            } else {
                passwordMismatchError = true
            }
        },
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color_palette3)),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = colorResource(R.color.color_palette1),
            modifier = modifier
                .padding(end = 10.dp)
        )
        Text(text = "Ganti Password",
            fontSize = 14.83.sp,
            fontFamily = Poppins.poppinsFamily,
            color = colorResource(id = R.color.color_palette1)
        )
    }

    if (passwordMismatchError) {
        Text(
            text = "Password baru tidak cocok.",
            color = Color.Red,
            modifier = modifier.padding(top = 10.dp)
        )
    }
}
