package com.gatenzteam.sipolan.ui.detail_pelanggaran

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun DetailPelanggaranScreen(
    modifier: Modifier = Modifier
) {
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
        ){
            Image(
                painter = painterResource(id = R.drawable.foto_pelanggaran),
                contentDescription = null,
            )
        }
        Column(
            modifier = modifier
                .padding(10.dp)
        ){
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = "Jenis Pelanggaran",
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    color = ColorPalette4
                )
                CustomText(
                    text = "Tidak Menggunakan Helm",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = ColorPalette4
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = "Plat Kendaraan",
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    color = ColorPalette4
                )
                CustomText(
                    text = "DK9238ASC",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = ColorPalette4
                )
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = "Tanggal",
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    color = ColorPalette4
                )
                CustomText(
                    text = "28-11-2023",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = ColorPalette4
                )
            }
        }
    }
}