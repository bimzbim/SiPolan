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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Traffic
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gatenzteam.sipolan.ScrollToTop
import com.gatenzteam.sipolan.ui.component.CustomFilterButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import kotlinx.coroutines.launch

@Composable
fun DeteksiScreen(
    navController : NavHostController,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var filterState by rememberSaveable { mutableStateOf(0) }
    val showButton: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }

    Box(
        modifier = modifier
            .background(ColorPalette1)
            .padding(horizontal = 25.dp)
    ){
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 60.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
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
                            isFilterActive = if(filterState == 1) true else false,
                            icon = Icons.Filled.Traffic,
                            contentDescription = "Pelanggaran lampu merah",
                            modifier = modifier.weight(1f)
                        )
                        Spacer(modifier = modifier.width(15.dp))
                        CustomFilterButton(
                            onClick = { filterState = 2 },
                            isFilterActive = if(filterState == 2) true else false,
                            icon = Icons.Filled.CarCrash,
                            contentDescription = "Pelanggaran lampu merah",
                            modifier = modifier.weight(1f)
                        )
                        Spacer(modifier = modifier.width(15.dp))
                        CustomFilterButton(
                            onClick = { filterState = 3 },
                            isFilterActive = if(filterState == 3) true else false,
                            icon = Icons.Filled.Groups,
                            contentDescription = "Pelanggaran lampu merah",
                            modifier = modifier.weight(1f)
                        )
                    }

                }
            }
            items(DataDeteksi.dummy, key = { it.id }) { deteksi ->
                DeteksiListItem(
                    onClick = {
                        navController.navigate(Screen.DetailPelanggaran.route)
                    },
                    img = deteksi.img,
                    jenis = deteksi.jenis,
                    nopol = deteksi.nopol,
                    tgl = deteksi.tgl,
                    modifier = Modifier.fillMaxWidth()
                )
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
            ScrollToTop(
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
