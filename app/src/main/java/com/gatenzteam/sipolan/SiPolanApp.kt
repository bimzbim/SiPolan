package com.gatenzteam.sipolan

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.navigation.NavigationItem
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.screen.artikel.ArtikelScreen
import com.gatenzteam.sipolan.ui.screen.artikel_detail.ArtikelDetailScreen
import com.gatenzteam.sipolan.ui.screen.detail_bayar.DetailBayarScreen
import com.gatenzteam.sipolan.ui.screen.deteksi.DeteksiScreen
import com.gatenzteam.sipolan.ui.screen.edit_akun.EditAkunScreen
import com.gatenzteam.sipolan.ui.screen.ganti_password.GantiPasswordScreen
import com.gatenzteam.sipolan.ui.screen.home.HomeScreen
import com.gatenzteam.sipolan.ui.screen.metode_bayar.MetodeBayarScreen
import com.gatenzteam.sipolan.ui.screen.pelanggaran_saya.PelanggaranSayaScreen
import com.gatenzteam.sipolan.ui.screen.profile.ProfileScreen
import com.gatenzteam.sipolan.ui.screen.pusat_bantuan.PusatBantuanScreen
import com.gatenzteam.sipolan.ui.screen.riwayat_bayar.RiwayatBayarScreen
import com.gatenzteam.sipolan.ui.theme.colorpalette1
import com.gatenzteam.sipolan.ui.theme.colorpalette2
import com.gatenzteam.sipolan.ui.theme.colorpalette3
import com.gatenzteam.sipolan.ui.theme.colorpalette4

@Composable
fun SiPolanApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                navController = navController
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(Screen.Deteksi.route) {
                DeteksiScreen()
            }
            composable(Screen.EditAkun.route){
                EditAkunScreen(navController)
            }
            composable(Screen.RiwayatPembayaran.route){
                RiwayatBayarScreen(navController)
            }
            composable(Screen.PelanggaranSaya.route){
                PelanggaranSayaScreen()
            }
            composable(Screen.PusatBantuan.route){
                PusatBantuanScreen()
            }
            composable(Screen.GantiPassword.route){
                GantiPasswordScreen(navController)
            }
            composable(Screen.DetailPembayaran.route){
                DetailBayarScreen(navController)
            }
            composable(Screen.MetodePembayaran.route){
                MetodeBayarScreen()
            }
            composable(Screen.Artikel.route){
                ArtikelScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorpalette1,
            titleContentColor = colorpalette4,
        ),
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo_polan_without_text),
                contentDescription = null,
                modifier = Modifier
                    .height(64.dp)
                    .padding(vertical = 10.dp)
            )
        },
        navigationIcon = {
            if(currentRoute != Screen.Home.route){
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = colorpalette3)
                }
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(Screen.Profile.route){
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            }) {
                Image(
                    painter = painterResource(id = R.drawable.photo_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    )
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier,
        containerColor = colorpalette1
    ){
        val navigationItem = listOf(
            NavigationItem(
                title = stringResource(id = R.string.navitem_first),
                icon = Icons.Outlined.Home,
                screen = Screen.Home,
            ),
            NavigationItem(
                title = stringResource(id = R.string.navitem_second),
                icon = Icons.Outlined.Person,
                screen = Screen.Profile
            ),
            NavigationItem(
                title = stringResource(id = R.string.navitem_third),
                icon = Icons.Outlined.Warning,
                screen = Screen.Deteksi
            )
        )
        navigationItem.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label =
                {
                    CustomText(
                        text = item.title
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorpalette3,
                    selectedTextColor = colorpalette3,
                    indicatorColor = colorpalette2,
                    unselectedIconColor = colorpalette4,
                    unselectedTextColor = colorpalette4,
                ),
            )
        }
    }
}
