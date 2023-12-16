package com.gatenzteam.sipolan.ui.screen.konfirmasi_pembayaran

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun KonfirmasiPembayaranScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ){
        CustomText(
            text = stringResource(R.string.konfirmasi_title),
            fontWeight = FontWeight.Bold,
            color = ColorPalette3,
            modifier = modifier
                .padding(bottom = 10.dp)
                .align(Alignment.Start)
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(
                    border = BorderStroke(3.dp, ColorPalette2),
                    shape = RoundedCornerShape(15.dp)
                )
        ){
            CustomIconButton(
                onClick = { /*TODO*/ },
                icon = Icons.Filled.CloudUpload,
                text = stringResource(R.string.konfirmasi_upload),
                modifier = modifier
                    .width(190.dp)
                    .align(Alignment.Center)
            )
        }
        CustomText(
            text = stringResource(R.string.konfirmasi_text),
            fontSize = 13.sp,
            color = ColorPalette4,
            modifier = modifier
                .padding(top = 15.dp)
                .align(Alignment.Start)
        )
    }
}