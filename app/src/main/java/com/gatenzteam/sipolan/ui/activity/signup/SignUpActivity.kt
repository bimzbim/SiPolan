package com.gatenzteam.sipolan.ui.activity.signup

import android.content.Intent
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
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Garage
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.activity.verification.VerificationActivity
import com.gatenzteam.sipolan.ui.component.CustomCheckbox
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.SiPolanTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpScreen()
        }
    }

    @Composable
    private fun SignUpScreen(
        modifier: Modifier = Modifier
    ) {
        var fullName by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var vehicleNumber by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var visibilityPassword by rememberSaveable { mutableStateOf(false) }
        var tncAgreement by rememberSaveable { mutableStateOf(false) }

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
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(700),
                    color = colorResource(R.color.color_palette3),
                )
            )

            Text(
                text = "ipsum dolor sit amet, consectetur\nadipiscing elit, sed do eiusmod et dolore\n magna aliqua.",
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
                value = fullName,
                onValueChange = { fullName = it },
                label = "Nama Lengkap",
                singleLine = true,
                placeholder = "Nama Lengkap Anda",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                },
                modifier = modifier
            )

            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                singleLine = true,
                placeholder = "Alamat Email",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Mail,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                },
                modifier = modifier
            )

            CustomTextField(
                value = vehicleNumber,
                onValueChange = { vehicleNumber = it },
                label = "Plat Nomer Kendaraan",
                singleLine = true,
                placeholder = "Masukan Plat Nomer Kendaraan",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Garage,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                },
                modifier = modifier
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
                    val tintIcon = if (visibilityPassword) colorResource(R.color.color_palette3) else colorResource(
                        R.color.color_palette4)

                    IconButton(onClick = {visibilityPassword = !visibilityPassword}){
                        Icon(
                            imageVector  = icon,
                            contentDescription = contentDescription,
                            tint = tintIcon
                        )
                    }
                },
                modifier = modifier
            )

            CustomCheckbox(
                value = tncAgreement,
                onCheckedChange = { tncAgreement = it },
                text = "Setuju dengan syarat dan ketentuan"
            )

            CustomIconButton(
                onClick = {
                    startActivity(Intent(this@SignUpActivity, VerificationActivity::class.java))
                    finish()
                },
                icon = Icons.Filled.PersonAdd,
                text = "Sign Up",
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
        }
    }

    @Preview
    @Composable
    fun SignUpScreenPreview() {
        SiPolanTheme {
            SignUpScreen()
        }
    }
}