package com.gatenzteam.sipolan.ui.activity.signin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.ui.activity.forgot.ForgotActivity
import com.gatenzteam.sipolan.ui.activity.signup.SignUpActivity
import com.gatenzteam.sipolan.ui.component.CustomIconButtom
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
        var visibilityPassword by rememberSaveable { mutableStateOf(false) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = colorResource(R.color.color_palette1))
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 30.dp)
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
                label = "Email",
                singleLine = true,
                placeholder = "Masukan Email",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                }
            )

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                singleLine = true,
                placeholder = "Masukan Password",
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
                }
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
                    .clickable {
                        startActivity(Intent(this@SignInActivity, ForgotActivity::class.java))
                    }
            )

            CustomIconButtom(
                onClick = {
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    finish()
                },
                icon = Icons.Filled.Login,
                text = "Sign In"
            )


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
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette1),
                        modifier = modifier
                            .size(25.dp)
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
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette1),
                        modifier = modifier
                            .size(22.dp)
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
                    text = "\u0020Daftar Disini",
                    modifier = modifier
                        .clickable {
                            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
                        }
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