package com.gatenzteam.sipolan.ui.screen.detail_bayar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomDetailText
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun DetailBayarScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ){
        Box(
            modifier = modifier
                .height(225.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .border(
                        border = BorderStroke(3.dp, ColorPalette2),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .height(210.dp)
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
            ){
                CustomDetailText("Jenis Pelanggaran", "Tidak Menggunakan Helm", modifier.padding(bottom = 10.dp))
                CustomDetailText("Plat Kendaraan", "DK9238ASC", modifier.padding(bottom = 10.dp))
                CustomDetailText("Tanggal", "28-11-2023")
            }
            Box(
                modifier = modifier
                    .align(Alignment.TopCenter)
                    .background(color = ColorPalette3, shape = RoundedCornerShape(15.dp))
            ){
                CustomText(
                    text = "Menunggu Pembayaran",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = ColorPalette2,
                    modifier = modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        CustomText(
            textAlign = TextAlign.Left,
            text = "Bayar Melalui",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = ColorPalette4
        )

        Spacer(modifier = Modifier.height(10.dp))

        MethodSection {
            navController.navigate(it) {
                restoreState = true
                launchSingleTop = true
            }
        }
    }
}

@Composable
fun MethodSection(onSettingClick: (String) -> Unit) {
    MethodItem(text = stringResource(id = R.string.metode1), icon = R.drawable.shopeepay_icon) {
        onSettingClick(Screen.TataCaraBayar.route)
    }
    MethodItem(text = stringResource(id = R.string.metode2), icon = R.drawable.dana_icon) {
        onSettingClick(Screen.TataCaraBayar.route)
    }
    MethodItem(text = stringResource(id = R.string.metode3),icon = R.drawable.gopay_icon) {
        onSettingClick(Screen.TataCaraBayar.route)
    }
    MethodItem(text = stringResource(id = R.string.metode4), icon = R.drawable.ovo_icon) {
        onSettingClick(Screen.TataCaraBayar.route)
    }
}


@Composable
fun MethodItem(
    text: String,
    icon: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(ColorPalette3, shape = RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                onClick()
            }
    ){
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ){
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(shape = CircleShape)
            )
            CustomText(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = ColorPalette2,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 15.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}