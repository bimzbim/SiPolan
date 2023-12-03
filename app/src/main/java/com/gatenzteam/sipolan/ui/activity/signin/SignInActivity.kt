package com.gatenzteam.sipolan.ui.activity.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = colorResource(R.color.color_palette1))
                .fillMaxSize()
                .padding(horizontal = 25.dp, vertical = 25.dp)
                .verticalScroll(rememberScrollState())
        ){
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(700),
                    color = colorResource(R.color.color_palette3),
                    )
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit, sed do eiusmod et\ndolore magna aliqua.",
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(400),
                    color = colorResource(R.color.color_palette4),
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .padding(bottom = 50.dp)
            )
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text("Email / Phone Number")
                },
                singleLine = true,
                placeholder = {
                    Text("Email / Phone Number")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                },
                modifier = modifier
            )

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text("Password")
                },
                singleLine = true,
                placeholder = {
                    Text("Masukan Password")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                },
                modifier = modifier
            )
            Text(
                text = "Lupa Password?",
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(700),
                    color = colorResource(R.color.color_palette3),
                ),
                modifier = modifier
                    .padding(top = 15.dp, bottom = 30.dp)
            )

            Button(
                onClick = {
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    finish()
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color_palette3)),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    tint = colorResource(R.color.color_palette1),
                    modifier = modifier
                        .padding(end = 10.dp)
                )
                Text(text = "Sign In",
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    color = colorResource(id = R.color.color_palette1)
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .padding(vertical = 30.dp)
            ){
                Divider(
                    color = colorResource(id = R.color.color_palette4),
                )
                Text(
                    style = TextStyle(
                        background = colorResource(id = R.color.color_palette1),
                        color = colorResource(id = R.color.color_palette4),
                        fontFamily = Poppins.poppinsFamily,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    ),
                    text = "\u0020Atau Lanjut Dengan\u0020",
                    modifier = modifier
                        .width(150.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                val context = LocalContext.current
                Button(
                    onClick = {
                        Toast.makeText( context, "Login Facebook", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color_palette3)),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette1)
                    )
                }

                Button(
                    onClick = {
                        Toast.makeText( context, "Login Google", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color_palette3)),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette1)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(vertical = 15.dp)
            ){
                Text(
                    style = TextStyle(
                        background = colorResource(id = R.color.color_palette1),
                        color = colorResource(id = R.color.color_palette4),
                        fontFamily = Poppins.poppinsFamily,
                        fontSize = 12.sp
                    ),
                    text = "Belum memiliki akun?"
                )
                Text(
                    style = TextStyle(
                        background = colorResource(id = R.color.color_palette1),
                        color = colorResource(id = R.color.color_palette3),
                        fontFamily = Poppins.poppinsFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700)
                    ),
                    text = "\u0020Daftar Disini"
                )
            }
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