package com.gatenzteam.sipolan.ui.activity.forgot

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.ui.theme.SiPolanTheme

class ForgotActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForgotScreen()
        }
    }

    @Composable
    fun ForgotScreen(
        modifier: Modifier = Modifier
    ) {

        var email by rememberSaveable { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = ColorPalette1)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 30.dp)
        ){

            Icon(
                imageVector = Icons.Filled.LockReset,
                contentDescription = null,
                tint = ColorPalette3,
                modifier = modifier
                    .size(150.dp)
            )
            Text(
                text = "Lupa Password",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(700),
                    color = ColorPalette3,
                ),
                modifier = modifier
                    .padding(top = 30.dp, bottom = 15.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit, sed do eiusmod et\ndolore magna aliqua.",
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(400),
                    color = ColorPalette4,
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .padding(bottom = 15.dp)
            )
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                singleLine = true,
                placeholder = "Masukan Email",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = ColorPalette3
                    )
                },
                modifier = modifier
                    .padding(bottom = 25.dp)
            )
            CustomIconButton(
                onClick = {
                    startActivity(Intent(this@ForgotActivity, MainActivity::class.java))
                    finish()
                },
                icon = Icons.Filled.LockReset,
                text = "Forgot Password"
            )
        }
    }

    @Preview
    @Composable
    fun ForgotScreenPreview() {
        SiPolanTheme {
            ForgotScreen()
        }
    }
}