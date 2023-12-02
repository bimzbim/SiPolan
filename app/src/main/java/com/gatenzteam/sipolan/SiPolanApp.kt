package com.gatenzteam.sipolan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gatenzteam.sipolan.ui.navigation.NavigationItem
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.screen.deteksi.DeteksiScreen
import com.gatenzteam.sipolan.ui.screen.home.HomeScreen
import com.gatenzteam.sipolan.ui.screen.profile.ProfileScreen

@Composable
fun SiPolanApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        topBar = {
            TopAppBar(navController = navController)
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
                ProfileScreen()
            }
            composable(Screen.Deteksi.route) {
                DeteksiScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController) {
    val profileImageModifier = Modifier
        .size(40.dp)
        .clip(CircleShape)

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
            title = {
            Image(
                painter = painterResource(id = R.drawable.logo_polan),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(Screen.Profile.route)
            }) {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .then(profileImageModifier)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.photo_profile),
                        contentDescription = "Profile",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    )
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar(
        modifier = modifier
    ){
        val navigationItem = listOf(
            NavigationItem(
                title = stringResource(id = R.string.navitem_first),
                icon = Icons.Outlined.Home,
                screen = Screen.Home
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
                selected = false,
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
                label = { Text(item.title) }
            )
        }
    }
}
