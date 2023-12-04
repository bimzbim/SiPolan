package com.gatenzteam.sipolan.ui.activity.verification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins

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
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Verify your Account",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(700),
                    color = colorResource(R.color.color_palette3),
                    textAlign = TextAlign.Start,
                ),
                modifier = modifier
                    .padding(top = 30.dp, bottom = 5.dp)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur\nadipiscing elit, sed do eiusmod et\ndolore magna aliqua.",
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(400),
                    color = colorResource(R.color.color_palette4),
                    textAlign = TextAlign.Start,
                ),
                modifier = modifier
                    .padding(bottom = 15.dp)
            )
        }
    }
}