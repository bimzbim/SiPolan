package com.gatenzteam.sipolan.ui.activity.signup

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
import androidx.compose.material.icons.filled.Garage
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.activity.signin.SignInActivity
import com.gatenzteam.sipolan.ui.activity.verification.VerificationActivity
import com.gatenzteam.sipolan.ui.component.CustomCheckbox
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.ui.theme.SiPolanTheme
import com.gatenzteam.sipolan.utils.AuthViewModelFactory

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpScreen()
        }
    }

    @Composable
    private fun SignUpScreen(
        modifier: Modifier = Modifier,
        viewModel: SignUpViewModel = viewModel(
            factory = AuthViewModelFactory(Injection.provideAuthRepository())
        )
    ) {
        var fullName by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var vehicleNumber by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var visibilityPassword by rememberSaveable { mutableStateOf(false) }
        var tncAgreement by rememberSaveable { mutableStateOf(false) }
        var signUpEnable by rememberSaveable { mutableStateOf(true) }
        val signUpResult by viewModel.signUpState.collectAsState()

        Box(modifier = modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .background(color = ColorPalette1)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 25.dp, vertical = 30.dp)
            ) {
                CustomText(
                    text = stringResource(id = R.string.signup_title),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = ColorPalette3,
                    )
                )

                CustomText(
                    text = stringResource(id = R.string.signup_subtitle),
                    style = TextStyle(
                        fontSize = 14.83.sp,
                        fontWeight = FontWeight(400),
                        color = ColorPalette4,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = modifier
                        .padding(bottom = 25.dp)
                )

                CustomTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    placeholder = stringResource(id = R.string.signup_input_nama),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AccountBox,
                            contentDescription = null,
                            tint = ColorPalette3
                        )
                    },
                    singleLine = true,
                    modifier = modifier.padding(bottom = 15.dp)
                )

                CustomTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = stringResource(id = R.string.signup_input_email),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = null,
                            tint = ColorPalette3
                        )
                    },
                    singleLine = true,
                    modifier = modifier.padding(bottom = 15.dp)
                )

                CustomTextField(
                    value = vehicleNumber,
                    onValueChange = { vehicleNumber = it },
                    placeholder = stringResource(id = R.string.signup_input_nopol),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Garage,
                            contentDescription = null,
                            tint = ColorPalette3
                        )
                    },
                    singleLine = true,
                    modifier = modifier.padding(bottom = 15.dp)
                )

                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = stringResource(id = R.string.signup_input_pass),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null,
                            tint = ColorPalette3
                        )
                    },
                    trailingIcon = {
                        val icon =
                            if (visibilityPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val tintIcon = if (visibilityPassword) ColorPalette3 else ColorPalette4

                        IconButton(onClick = { visibilityPassword = !visibilityPassword }) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = tintIcon
                            )
                        }
                    },
                    visualTransformation = if (visibilityPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    modifier = modifier.padding(bottom = 15.dp)
                )

                CustomCheckbox(
                    value = tncAgreement,
                    onCheckedChange = { tncAgreement = it },
                    text = stringResource(id = R.string.signup_terms),
                )

                CustomIconButton(
                    onClick = {
                        signUpEnable = false
                        viewModel.signUp(fullName, email, vehicleNumber, password)
                        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                        finish()
                    },
                    icon = Icons.Filled.PersonAdd,
                    text = stringResource(id = R.string.signup_button),
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .padding(vertical = 30.dp)
                ) {
                    Divider(
                        color = ColorPalette4,
                    )
                    CustomText(
                        style = TextStyle(
                            background = ColorPalette1,
                            color = ColorPalette4,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        ),
                        text = stringResource(id = R.string.signup_divider),
                        modifier = modifier
                            .width(150.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val context = LocalContext.current
                    Button(
                        onClick = {
                            Toast.makeText(context, R.string.login_fb, Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(ColorPalette3),
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(horizontal = 5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = null,
                            tint = ColorPalette1,
                            modifier = modifier
                                .size(25.dp)
                        )
                    }

                    Button(
                        onClick = {
                            Toast.makeText(context, R.string.login_google, Toast.LENGTH_SHORT)
                                .show()
                        },
                        colors = ButtonDefaults.buttonColors(ColorPalette3),
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .padding(horizontal = 5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = null,
                            tint = ColorPalette1,
                            modifier = modifier
                                .size(22.dp)
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ){
                when(signUpResult){
                    is ResultState.Success -> {
                        val signUpResponse = (signUpResult as ResultState.Success).data
                        Toast.makeText(LocalContext.current, signUpResponse.message, Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@SignUpActivity, VerificationActivity::class.java)
                        startActivity(intent)
                        finish()

                        signUpEnable = true
                    }
                    is ResultState.Error -> {
                        val errorResponse = (signUpResult as ResultState.Error).error
                        Toast.makeText(LocalContext.current, errorResponse, Toast.LENGTH_SHORT).show()

                        signUpEnable = true
                    }
                    is ResultState.Loading -> {
                        if (!signUpEnable) {
                            CircularProgressIndicator(
                                color = ColorPalette3,
                                strokeWidth = 3.dp,
                                modifier = Modifier
                                    .padding(25.dp)
                                    .size(40.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                    }
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