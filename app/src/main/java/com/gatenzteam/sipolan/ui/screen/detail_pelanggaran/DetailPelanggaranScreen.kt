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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileDownloadOff
import androidx.compose.material.icons.filled.Payments
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
import com.gatenzteam.sipolan.ui.component.CustomDetailText
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.screen.deteksi.DeteksiViewModel
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.DeteksiViewModelFactory

@Composable
fun DetailPelanggaranScreen(
    navController: NavHostController,
    violationId: Int,
    viewModel: DeteksiViewModel = viewModel(
        factory = DeteksiViewModelFactory(Injection.provideDeteksiRepository())
    ),
    modifier: Modifier = Modifier
) {
    val detailPelanggaranState by viewModel.detailPelanggaranState.collectAsState()

    LaunchedEffect(violationId) {
        viewModel.getPelanggaranDetail(violationId)
    }

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
            when(detailPelanggaranState){
                is ResultState.Success -> {
                    val detailPelanggaran = (detailPelanggaranState as ResultState.Success).data.data
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
                        CustomDetailText(stringResource(R.string.detailpelanggaran_jenis), detailPelanggaran.type, modifier.padding(bottom = 10.dp))
                        CustomDetailText(stringResource(R.string.detailpelanggaran_plat), detailPelanggaran.vehicleNumberPlate, modifier.padding(bottom = 10.dp))
                        CustomDetailText(stringResource(R.string.detailpelanggaran_tgl), detailPelanggaran.timestamp)
                        Spacer(modifier = modifier.height(60.dp))
                    }
                }
                is ResultState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(25.dp)
                            .size(40.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
                is ResultState.Error -> {
                    val errorResponse = (detailPelanggaranState as ResultState.Error).error
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
                        textAlign = TextAlign.Start,
                        color = ColorPalette4
                    )
                    CustomText(
                        text = "Rp 100.000",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start,
                        color = ColorPalette4
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
