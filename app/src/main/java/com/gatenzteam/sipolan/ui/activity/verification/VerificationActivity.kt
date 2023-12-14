package com.gatenzteam.sipolan.ui.activity.verification

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailLock
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

class VerificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerificationScreen()
        }
    }

    @Composable
    fun VerificationScreen(
        modifier: Modifier = Modifier
    ) {
        var otpCode by rememberSaveable { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = ColorPalette1)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 30.dp)
        ){
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .fillMaxWidth()
            ){
                CustomText(
                    text = stringResource(id = R.string.veri_title),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = ColorPalette3,
                        textAlign = TextAlign.Start,
                    ),
                    modifier = modifier
                        .padding(bottom = 5.dp)
                )
                CustomText(
                    text = stringResource(id = R.string.veri_subtitle),
                    style = TextStyle(
                        fontSize = 14.83.sp,
                        fontWeight = FontWeight(400),
                        color = ColorPalette4,
                        textAlign = TextAlign.Start,
                    ),
                    modifier = modifier
                        .padding(bottom = 15.dp)
                )
            }

            Box(
                modifier = modifier
                    .height(320.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .height(240.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            color = ColorPalette3,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(horizontal = 25.dp)
                ){
                    CustomText(
                        text = stringResource(id = R.string.veri_text1),
                        style = TextStyle(
                            fontSize = 14.83.sp,
                            fontWeight = FontWeight(600),
                            color = ColorPalette1,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = modifier
                            .padding(top = 80.dp, bottom = 10.dp)
                    )

                    CustomTextField(
                        value = otpCode,
                        onValueChange = { otpCode = it },
                        placeholder = stringResource(id = R.string.veri_input_otp),
                        placeholderColor = ColorPalette1,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.MailLock,
                                contentDescription = null,
                                tint = ColorPalette1
                            )
                        },
                        singleLine = true,
                        color = OutlinedTextFieldDefaults.colors(
                            cursorColor = ColorPalette1,
                            focusedLabelColor = ColorPalette1,
                            unfocusedLabelColor = ColorPalette1,
                            focusedTextColor = ColorPalette1,
                            focusedBorderColor = ColorPalette2,
                            unfocusedBorderColor = ColorPalette2
                        ),
                        modifier = modifier.padding(bottom = 15.dp)
                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.logo_verification),
                    contentDescription = null,
                    modifier = modifier
                        .size(150.dp)
                        .align(Alignment.TopCenter)
                )
            }

            CustomText(
                text = stringResource(id = R.string.veri_text2),
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontWeight = FontWeight(400),
                    color = ColorPalette4,
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .padding(vertical = 20.dp)
            )

            CustomIconButton(
                onClick = {
                    startActivity(Intent(this@VerificationActivity, MainActivity::class.java))
                    finish()
                },
                icon = Icons.Filled.MarkEmailUnread,
                text = stringResource(id = R.string.veri_button),
                modifier = modifier
                    .width(190.dp)
            )
        }
    }
}