package com.gatenzteam.sipolan.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.activity.onboarding.OnboardingActivity
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SplashScreen()
        }
    }

    @Composable
    private fun SplashScreen(
        modifier: Modifier = Modifier
    ) {
        LaunchedEffect(key1 = true){
            delay(2000)
            startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
            finish()
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .background(ColorPalette1)
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_polan),
                modifier = modifier.size(width = 150.dp, height = 200.dp),
                contentDescription = stringResource(id = R.string.splashscreen_contentdesc))
        }
    }

    @Preview(name = "Splash Screen")
    @Composable
    fun SplashScreenPreview() {
        SplashScreen()
    }
}