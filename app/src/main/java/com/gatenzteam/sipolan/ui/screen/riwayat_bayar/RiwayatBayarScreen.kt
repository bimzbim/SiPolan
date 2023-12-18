package com.gatenzteam.sipolan.ui.screen.riwayat_bayar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.ScrollToTopButton
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.RiwayatBayarViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun RiwayatBayarScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RiwayatBayarViewModel = viewModel(
        factory = RiwayatBayarViewModelFactory(Injection.provideRiwayatBayarRepository())
    ),
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val showButton: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    val dataRiwayatBayar by viewModel.riwayatBayarState.collectAsState()

    Box(
        modifier = modifier
            .background(ColorPalette1)
            .padding(horizontal = 25.dp)
    ) {

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 60.dp),
            modifier = modifier
                .fillMaxSize()
        ) {
            item { 
                Spacer(modifier = modifier.height(20.dp))
            }
            viewModel.getRiwayatBayar(userId = 1,limit = 10)
            when (dataRiwayatBayar) {
                is ResultState.Loading -> {
                    item {
                        LinearProgressIndicator(
                            color = ColorPalette3,
                            trackColor = ColorPalette1,
                            modifier = modifier
                                .fillMaxWidth()
                        )
                    }
                }
                is ResultState.Success -> {
                    val deteksiResponse = (dataRiwayatBayar as ResultState.Success).data

                    items(deteksiResponse.data.payments, key = { it.idPembayaran }) { pembayaran ->
                        BayarListItem(
                            onClick = { navController.navigate(Screen.DetailPembayaran.route) },
                            id = pembayaran.idPembayaran,
                            biaya = pembayaran.biaya,
                            tanggal = pembayaran.timestamp,
                            status = pembayaran.status,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                is ResultState.Error -> {
                    val errorResponse = (dataRiwayatBayar as ResultState.Error).error
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = modifier
                                .fillMaxSize()
                        ){
                            Icon(
                                imageVector = Icons.Filled.Traffic,
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

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(vertical = 15.dp)
                .align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(index = 0)
                    }
                }
            )
        }
    }
}

@Composable
fun BayarListItem(
    onClick: () -> Unit,
    id: String,
    biaya: String,
    tanggal: String,
    status: String,
    modifier: Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = ColorPalette2
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .clickable {
                onClick()
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
        ) {
            Column {
                CustomText(
                    text = stringResource(R.string.riwayat_id, id),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = ColorPalette3
                )
                CustomText(
                    text = stringResource(R.string.riwayat_biaya, biaya),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = ColorPalette4
                )
                CustomText(
                    text = stringResource(R.string.riwayat_tanggal, tanggal),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = ColorPalette4
                )
                CustomText(
                    text = stringResource(R.string.riwayat_status, status),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = ColorPalette4
                )
            }

            Column(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .align(Alignment.CenterVertically)
            ) {
                IconButton(
                    onClick = {
                        onClick()
                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.color_palette3))
                ) {
                    Icon(
                        imageVector = Icons.Default.Payments,
                        contentDescription = null,
                        tint = colorResource(id = R.color.color_palette1),
                    )
                }
            }
        }
    }
}




