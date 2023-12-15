package com.gatenzteam.sipolan.ui.screen.artikel

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ScrollToTop
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import kotlinx.coroutines.launch

@Composable
fun ArtikelScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val showButton: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    var searchQuery by rememberSaveable { mutableStateOf("") }

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
                CustomTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = stringResource(R.string.artikel_cari),
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    },
                    singleLine = true,
                    modifier = modifier
                        .padding(vertical = 20.dp)
                )
            }
            items(DataArtikel.dummy, key = { it.id }) { artikel ->
                ArtikelListItem(
                    onClick = { navController.navigate(Screen.ArtikelDetail.route) },
                    judul = artikel.judul,
                    img = artikel.img,
                    modifier = modifier
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
fun ArtikelListItem(
    onClick: () -> Unit,
    judul: String,
    img: Int,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(bottom = 20.dp)
            .clickable(onClick = onClick)
    ) {
        Box{
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
            )

            Box(
                modifier = modifier
                    .fillMaxSize()
                    .alpha(0.7F)
                    .background(ColorPalette2, RoundedCornerShape(15.dp))
            )

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center
            ) {
                CustomText(
                    text = judul,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = ColorPalette4,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row {
                    CustomText(
                        text = stringResource(R.string.artikel_selengkapnya),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.83.sp,
                        color = ColorPalette3,
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = colorResource(R.color.color_palette3)
                    )
                }

            }
        }
    }
}

