package com.gatenzteam.sipolan.ui.screen.artikel_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.FileDownloadOff
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.ArtikelData
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.screen.artikel.ArtikelViewModel
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.ArtikelViewModelFactory

@Composable
fun ArtikelDetailScreen(
    modifier: Modifier = Modifier,
    articleId: Int,
    viewModel: ArtikelViewModel = viewModel(
        factory = ArtikelViewModelFactory(Injection.provideArtikelRepository())
    ),
) {
    val detailArtikelState by viewModel.artikelDetailState.collectAsState()

    LaunchedEffect(articleId) {
        viewModel.getArtikelDetail(articleId)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ) {
        when (detailArtikelState) {
            is ResultState.Success -> {
                val detailArtikelResponse = (detailArtikelState as ResultState.Success).data
                DetailArtikel(dataArtikel = detailArtikelResponse.data)
            }
            is ResultState.Loading -> {
                CircularProgressIndicator(
                    color = ColorPalette3,
                    strokeWidth = 3.dp,
                    modifier = Modifier
                        .padding(25.dp)
                        .size(40.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
            is ResultState.Error -> {
                val errorResponse = (detailArtikelState as ResultState.Error).error
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxSize()
                ){
                    Icon(
                        imageVector = Icons.Filled.FileDownloadOff,
                        contentDescription = null,
                        tint = ColorPalette3,
                        modifier = modifier
                            .size(150.dp)
                    )
                    CustomText(text = errorResponse, fontSize = 15.sp, color = ColorPalette4, textAlign = TextAlign.Center)
                }

            }
        }
    }
}

@Composable
fun DetailArtikel(
    dataArtikel: ArtikelData,
    modifier: Modifier = Modifier
) {
    CustomText(
        text = dataArtikel.title,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        color = ColorPalette3,
        maxLines = 2,
        modifier = modifier.fillMaxWidth()
    )
    CustomText(
        text = dataArtikel.createdAt,
        fontWeight = FontWeight.Normal,
        fontSize = 12.5.sp,
        textAlign = TextAlign.Center,
        color = ColorPalette4,
        modifier = modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
    )
    Card(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(3.dp, ColorPalette2),
        modifier = modifier.padding(bottom = 15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto_artikel),
            contentDescription = null,
        )
    }
    CustomText(
        text = dataArtikel.content,
        textAlign = TextAlign.Justify,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = ColorPalette4,
    )
}

