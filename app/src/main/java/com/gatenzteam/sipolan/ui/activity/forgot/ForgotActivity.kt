package com.gatenzteam.sipolan.ui.activity.forgot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class ForgotActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForgotScreen()
        }
    }

    @Composable
    fun ForgotScreen(
        modifier: Modifier = Modifier
    ) {

    }

    @Preview
    @Composable
    fun ForgotScreenPreview() {

    }
}