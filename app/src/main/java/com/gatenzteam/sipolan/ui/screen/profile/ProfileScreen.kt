package com.gatenzteam.sipolan.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.navigation.Screen

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        SettingsSection {
            navController.navigate(it){
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }
    }
}

@Composable
fun ProfileSection() {
    Box(
        modifier = Modifier
            .size(130.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo_profile),
            contentDescription = "Profile",
            modifier = Modifier
                .fillMaxSize()
        )

        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.color_palette3))
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Icon",
                modifier = Modifier
                    .clip(CircleShape)
                    .align(Alignment.Center)
                    .clickable {

                    },
                tint = colorResource(id = R.color.color_palette1)
            )
        }
    }

    Text(
        text = "Aditya Yoga",
        fontFamily = Poppins.poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(top = 10.dp)
    )

    Text(
        text = "DK 2938 ACL",
        fontFamily = Poppins.poppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.2.sp,
        modifier = Modifier
            .padding(top = 5.dp)
    )
}

@Composable
fun SettingsSection(onSettingClick: (String) -> Unit) {
    SettingItem(text = stringResource(id = R.string.setting1)) {
        onSettingClick(Screen.EditAkun.route)
    }
    SettingItem(text = stringResource(id = R.string.setting2)) {
        onSettingClick(Screen.RiwayatPembayaran.route)
    }
    SettingItem(text = stringResource(id = R.string.setting3)) {
        onSettingClick(Screen.PelanggaranSaya.route)
    }
    SettingItem(text = stringResource(id = R.string.setting4)) {
        onSettingClick(Screen.PusatBantuan.route)
    }
}


@Composable
fun SettingItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Icon Setting"
        )
    }
}

@Preview(name = "Profile")
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}
