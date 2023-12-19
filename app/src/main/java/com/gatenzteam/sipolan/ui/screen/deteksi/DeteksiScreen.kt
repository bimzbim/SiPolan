package com.gatenzteam.sipolan.ui.screen.deteksi

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.component.CustomFilterButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.ScrollToTopButton
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.DeteksiViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun DeteksiScreen(
    navController : NavHostController,
    viewModel: DeteksiViewModel = viewModel(
        factory = DeteksiViewModelFactory(Injection.provideDeteksiRepository())
    ),
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var filterState by rememberSaveable { mutableStateOf(0) }
    val showButton: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    val dataDeteksi by viewModel.deteksiState.collectAsState()

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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = modifier
                        .padding(vertical = 20.dp)
                        .fillMaxSize()
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        CustomFilterButton(
                            onClick = { filterState = 1 },
                            isFilterActive = filterState == 1,
                            icon = R.drawable.seatbelt_icon,
                            contentDescription = stringResource(R.string.deteksi_pelanggaran1),
                            modifier = modifier.weight(1f)
                        )
                        Spacer(modifier = modifier.width(15.dp))
                        CustomFilterButton(
                            onClick = { filterState = 2 },
                            isFilterActive = filterState == 2,
                            icon = R.drawable.helmet_icon,
                            contentDescription = stringResource(R.string.deteksi_pelanggaran2),
                            modifier = modifier.weight(1f)
                        )
                    }

                }
            }

            viewModel.getDeteksi(limit = 10)
            when (dataDeteksi) {
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
                    val deteksiResponse = (dataDeteksi as ResultState.Success).data

                    items(deteksiResponse.data.violations, key = { it.id }) { deteksi ->
                        DeteksiListItem(
                            onClick = {
                                navController.navigate("${Screen.DetailPelanggaran.route}/${deteksi.id}")
                            },
                            img = R.drawable.foto_pelanggaran,
                            jenis = deteksi.type,
                            location = deteksi.location,
                            nopol = deteksi.vehicleNumberPlate,
                            tgl = deteksi.timestamp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                is ResultState.Error -> {
                    val errorResponse = (dataDeteksi as ResultState.Error).error
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
fun DeteksiListItem(
    onClick: () -> Unit,
    img: Int,
    jenis: String,
    location: String,
    nopol: String,
    tgl: String,
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
        Column {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp))
            )

            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                CustomText(
                    text = jenis,
                    fontWeight = FontWeight.Bold,
                    color = ColorPalette3,
                    fontSize = 18.sp,
                )

                CustomText(
                    text = location,
                    fontWeight = FontWeight.Medium,
                    color = ColorPalette4,
                    fontSize = 11.12.sp
                )

                CustomText(
                    text = nopol,
                    fontWeight = FontWeight.Medium,
                    color = ColorPalette4,
                    fontSize = 11.12.sp
                )

                CustomText(
                    text = tgl,
                    fontWeight = FontWeight.Medium,
                    color = ColorPalette4,
                    fontSize = 11.12.sp
                )
            }
        }
    }
}
