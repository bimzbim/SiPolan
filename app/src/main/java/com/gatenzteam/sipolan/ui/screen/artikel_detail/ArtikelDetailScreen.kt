package com.gatenzteam.sipolan.ui.screen.artikel_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun ArtikelDetailScreen(
    modifier: Modifier = Modifier
) {
    val detailArtikel = DataDetailArtikel.dummy

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ){
        CustomText(
            text = detailArtikel.judul,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = ColorPalette3,
            maxLines = 2,
            modifier = modifier
                .fillMaxWidth()
        )
        CustomText(
            text = detailArtikel.tanggal,
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
            border = BorderStroke(3.dp, ColorPalette2),
            modifier = modifier
                .padding(bottom = 15.dp)
        ){
            Image(
                painter = painterResource(id = detailArtikel.img),
                contentDescription = "Thumbnail Artikel",
            )
        }
        CustomText(
            text = detailArtikel.isi,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Normal,
            fontSize = 12.5.sp,
            color = ColorPalette4,
        )
    }
}