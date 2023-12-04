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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.ScrollToTopButton
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.colorpalette1
import com.gatenzteam.sipolan.ui.theme.colorpalette2
import com.gatenzteam.sipolan.ui.theme.colorpalette3
import kotlinx.coroutines.launch

@Composable
fun RiwayatBayarScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorpalette1)
    ){
        RiwayatBayarColumn(onClick = {
            navController.navigate(Screen.DetailPembayaran.route)
        })
    }
}
@Composable
fun RiwayatBayarColumn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
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
            items(DataBayar.dummy, key = { it.id }) { bayar ->
                BayarListItem(
                    { onClick() },
                    id = bayar.id,
                    biaya = bayar.biaya,
                    tanggal = bayar.tanggal,
                    status = bayar.status,
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
fun BayarListItem(
    onClick: () -> Unit,
    id: String,
    biaya: String,
    tanggal: String,
    status: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = colorpalette2, shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "ID Pembayaran: #$id",
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = colorpalette3
                )
                Text(
                    text = "Biaya: Rp$biaya",
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
                Text(
                    text = "Tanggal: $tanggal",
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
                Text(
                    text = "Status: $status",
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
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
                        imageVector = Icons.Default.Person,
                        contentDescription = "Icon",
                        tint = colorResource(id = R.color.color_palette1),
                    )
                }
            }

        }
    }
}




