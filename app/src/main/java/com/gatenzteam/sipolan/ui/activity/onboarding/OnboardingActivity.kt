package com.gatenzteam.sipolan.ui.activity.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins
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
                    .padding(25 .dp)
                    .align(Alignment.BottomCenter)

            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_title),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily= Poppins.poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = stringResource(id = R.string.onboarding_subtitle),
                    color = Color.White,
                    fontSize = 14.83.sp,
                    fontFamily= Poppins.poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 25.dp)
                )
                Button(
                    onClick = {
                        startActivity(Intent(this@OnboardingActivity, MainActivity::class.java))
                        finish()
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color_palette3)),
                    modifier = Modifier
                        .height(50.dp)
                        .align(Alignment.End)
                ) {
                    Text(text = stringResource(id = R.string.onboarding_button),
                        fontSize = 15.sp,
                        fontFamily = Poppins.poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.color_palette1)
                    )
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

