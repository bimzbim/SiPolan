package com.gatenzteam.sipolan.ui.activity.signin

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gatenzteam.sipolan.ui.theme.SiPolanTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreen()
        }
    }

    @Composable
    private fun SignInScreen(
        modifier: Modifier = Modifier
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = modifier
                .background(color = Color(R.color.color_palette1))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = colorResource(R.color.color_palette3),
                    )
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit, sed do eiusmod et\ndolore magna aliqua.",
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontWeight = FontWeight(400),
                    color = colorResource(R.color.color_palette4),
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .padding(bottom = 50.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                placeholder = { Text("Email") },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colorResource(id = R.color.color_palette3),
                    focusedLabelColor = colorResource(id = R.color.color_palette3),
                    focusedBorderColor = colorResource(id = R.color.color_palette3),
                    unfocusedBorderColor = colorResource(id = R.color.color_palette2)
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = modifier
                    .padding(bottom = 15.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                placeholder = { Text("Password") },
                shape = RoundedCornerShape(15.dp),
            )
        }
    }

    @Preview
    @Composable
    fun SignInScreenPreview() {
        SiPolanTheme {
            SignInScreen()
        }
    }
}