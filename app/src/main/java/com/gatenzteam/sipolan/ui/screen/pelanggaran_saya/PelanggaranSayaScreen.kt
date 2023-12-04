package com.gatenzteam.sipolan.ui.screen.pelanggaran_saya

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.ui.component.ScrollToTopButton
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.colorpalette1
import com.gatenzteam.sipolan.ui.theme.colorpalette2
import com.gatenzteam.sipolan.ui.theme.colorpalette3
import com.gatenzteam.sipolan.ui.theme.colorpalette4
import kotlinx.coroutines.launch

@Composable
fun PelanggaranSayaScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(colorpalette1)
    ){
        ColumnPelanggaran(onClick = { /*TODO*/ })
    }
}

@Composable
fun ColumnPelanggaran(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton: Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            items(DataPelanggaran.dummy, key = { it.id }) { pelanggaran ->
                PelanggaranListItem(
                    { onClick() },
                    img = pelanggaran.img,
                    jenis = pelanggaran.jenis,
                    nopol = pelanggaran.nopol,
                    tgl = pelanggaran.tgl,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                onClick = {
                    scope.launch {
                        listState.scrollToItem(index = 0)
                    }
                }
            )
        }
    }
}

@Composable
fun PelanggaranListItem(
    onClick: () -> Unit,
    img: Int,
    jenis: String,
    nopol: String,
    tgl: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .background(color = colorpalette2, shape = RoundedCornerShape(10.dp))
            .clickable {
                onClick()
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
            )

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = jenis,
                        fontFamily = Poppins.poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        color = colorpalette3,
                        fontSize = 18.sp,
                    )

                    Text(
                        text = nopol,
                        fontFamily = Poppins.poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorpalette4,
                        fontSize = 11.12.sp
                    )

                    Text(
                        text = tgl,
                        fontFamily = Poppins.poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorpalette4,
                        fontSize = 11.12.sp
                    )
                }
            }
        }
    }
}
