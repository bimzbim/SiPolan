package com.gatenzteam.sipolan.ui.screen.artikel_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun ArtikelDetailScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(ColorPalette1)
    ){
        val detailArtikel = DataDetailArtikel.dummy
        DetailArtikel(
            judul = detailArtikel.judul,
            tanggal = detailArtikel.tanggal,
            img = detailArtikel.img,
            isi = detailArtikel.isi,
            modifier = modifier
        )
    }
}

@Composable
fun DetailArtikel(
    judul: String,
    tanggal: String,
    img: Int,
    isi: String,
    modifier: Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(25.dp)
        ){
            CustomText(
                text = judul,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = ColorPalette3,
                maxLines = 2,
                modifier = modifier
                    .fillMaxWidth()
            )
            CustomText(
                text = tanggal,
                fontWeight = FontWeight.Normal,
                fontSize = 11.1.sp,
                textAlign = TextAlign.Center,
                color = ColorPalette4,
                modifier = modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            )
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = modifier
                    .padding(bottom = 15.dp)
            ){
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                )
            }
            CustomText(
                text = isi,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 12.5.sp,
                color = ColorPalette4,
            )
        }
    }
}