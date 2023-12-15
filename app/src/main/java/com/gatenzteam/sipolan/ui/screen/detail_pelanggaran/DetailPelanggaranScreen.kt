package com.gatenzteam.sipolan.ui.screen.detail_pelanggaran

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomDetailText
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2

@Composable
fun DetailPelanggaranScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .background(ColorPalette1)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 20.dp)
        ){
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.foto_pelanggaran),
                    contentDescription = null,
                )
            }
            Column(
                modifier = modifier
                    .padding(vertical = 20.dp)
            ){
                CustomDetailText(stringResource(R.string.detailpelanggaran_jenis), "Tidak Menggunakan Helm", modifier.padding(bottom = 10.dp))
                CustomDetailText(stringResource(R.string.detailpelanggaran_plat), "DK9238ASC", modifier.padding(bottom = 10.dp))
                CustomDetailText(stringResource(R.string.detailpelanggaran_tgl), "28-11-2023")
                Spacer(modifier = modifier.height(60.dp))
            }
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(ColorPalette2)
                .height(80.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                ){
                    CustomText(
                        text = stringResource(R.string.detailpelanggaran_total),
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start
                    )
                    CustomText(
                        text = "Rp 100.000",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start
                    )
                }
                CustomIconButton(
                    onClick = { navController.navigate(Screen.DetailPembayaran.route) },
                    icon = Icons.Filled.Payments,
                    text = stringResource(R.string.detailpelanggaran_bayar),
                    modifier = modifier
                        .width(180.dp)
                )
            }
        }
    }
}
