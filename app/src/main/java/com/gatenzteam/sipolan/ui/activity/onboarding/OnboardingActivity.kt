package com.gatenzteam.sipolan.ui.activity.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.activity.signin.SignInActivity
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.SiPolanTheme

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingScreen()
        }
    }

    @Composable
    fun OnboardingScreen() {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(25.dp)
                    .align(Alignment.BottomCenter)

            ) {
                CustomText(
                    text = stringResource(id = R.string.onboarding_title),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                CustomText(
                    text = stringResource(id = R.string.onboarding_subtitle),
                    color = Color.White,
                    fontSize = 14.83.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 25.dp)
                )
                Button(
                    onClick = {
                        startActivity(Intent(this@OnboardingActivity, SignInActivity::class.java))
                        finish()
                    },
                    colors = ButtonDefaults.buttonColors(ColorPalette3),
                    modifier = Modifier
                        .height( 50.dp)
                        .align(Alignment.End)
                ) {
                    Row{
                        CustomText(
                            text = stringResource(id = R.string.onboarding_button),
                            fontSize = 15.sp,
                            color = ColorPalette1,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = ColorPalette1
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun OnboardingScreenPreview() {
        SiPolanTheme {
            OnboardingScreen()
        }
    }
}

