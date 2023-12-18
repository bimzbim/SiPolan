package com.gatenzteam.sipolan.ui.screen.home

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.ScrollToTopButton
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.screen.artikel.ArtikelListItem
import com.gatenzteam.sipolan.ui.screen.artikel.ArtikelViewModel
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.ArtikelViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController : NavHostController,
    viewModel: ArtikelViewModel = viewModel(
        factory = ArtikelViewModelFactory(Injection.provideArtikelRepository())
    ),
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val showButton: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    val dataArtikel by viewModel.artikelState.collectAsState()

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
                .fillMaxSize()
        ){
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(vertical = 20.dp)
                    ){
                        CustomText (
                            text = stringResource(R.string.home_today),
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = ColorPalette4,
                            modifier = modifier
                                .weight(1f)
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = ColorPalette3,
                                contentColor = ColorPalette1
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = null,
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = modifier
                                .background(ColorPalette2, RoundedCornerShape(15.dp))
                                .weight(1f)
                                .height(110.dp)
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.seatbelt_icon),
                                contentDescription = null,
                                tint = ColorPalette3,
                                modifier = modifier
                                    .size(50.dp)
                                    .padding(bottom = 10.dp)
                            )
                            CustomText(text = "12", color = ColorPalette4)
                        }
                        Spacer(modifier = modifier.width(15.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = modifier
                                .background(ColorPalette2, RoundedCornerShape(15.dp))
                                .weight(1f)
                                .height(110.dp)

                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.helmet_icon) ,
                                contentDescription = null,
                                tint = ColorPalette3,
                                modifier = modifier
                                    .size(50.dp)
                                    .padding(bottom = 10.dp)
                            )
                            CustomText(text = "7", color = ColorPalette4)
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(vertical = 20.dp)
                    ){
                        CustomText (
                            text = stringResource(R.string.home_artikel),
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = ColorPalette4,
                            modifier = modifier
                                .weight(1f)
                        )
                        IconButton(
                            onClick = {
                                navController.navigate(Screen.Artikel.route)
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = ColorPalette3,
                                contentColor = ColorPalette1
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = null,
                            )
                        }
                    }

                }
            }
            viewModel.getArtikel(page = 1, limit = 10)
            when (dataArtikel) {
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
                    val artikelResponse = (dataArtikel as ResultState.Success).data

                    items(artikelResponse.articles, key = { it.id }) { artikel ->
                        ArtikelListItem(
                            onClick = {
                                navController.navigate("${Screen.ArtikelDetail.route}/${artikel.id}")
                            },
                            judul = artikel.title,
                            img = R.drawable.foto_artikel,
                            modifier = modifier
                        )
                    }
                }
                is ResultState.Error -> {
                    val errorResponse = (dataArtikel as ResultState.Error).error
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = modifier
                                .fillMaxSize()
                        ){
                            Icon(
                                imageVector = Icons.Filled.CloudSync,
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