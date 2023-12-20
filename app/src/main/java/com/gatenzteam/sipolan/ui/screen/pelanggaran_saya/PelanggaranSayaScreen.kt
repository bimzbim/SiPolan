package com.gatenzteam.sipolan.ui.screen.pelanggaran_saya

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.ScrollToTopButton
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.screen.deteksi.DeteksiListItem
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.PelanggaranSayaViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun PelanggaranSayaScreen(
    navController : NavHostController,
    viewModel: PelanggaranSayaViewModel = viewModel(
        factory = PelanggaranSayaViewModelFactory(Injection.providePelanggaranSayaRepository())
    ),
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val showButton: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    val dataPelanggaranSaya by viewModel.pelanggaranUserState.collectAsState()

    Box(
        modifier = modifier
            .background(ColorPalette1)
            .padding(horizontal = 25.dp)
    ){
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 60.dp),
            modifier = modifier
                .fillMaxSize()
        ){
            item {
                Spacer(modifier = modifier.height(20.dp))
            }
            viewModel.getPelanggaranUser(userId = 1,limit = 10)
            when (dataPelanggaranSaya) {
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
                    val deteksiResponse = (dataPelanggaranSaya as ResultState.Success).data

                    items(deteksiResponse.data.violations, key = { it.id }) { pelanggaran ->
                        DeteksiListItem(
                            onClick = {
                                navController.navigate("${Screen.DetailPelanggaran.route}/${pelanggaran.id}")
                            },
                            img = R.drawable.foto_pelanggaran,
                            jenis = pelanggaran.type,
                            location = pelanggaran.location,
                            nopol = pelanggaran.vehicleNumberPlate,
                            tgl = pelanggaran.timestamp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                is ResultState.Error -> {
                    val errorResponse = (dataPelanggaranSaya as ResultState.Error).error
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