package com.gatenzteam.sipolan.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.compose.rememberNavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ){
        Box(
            modifier = Modifier
                .height(180.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.photo_profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(170.dp)
                    .clip(CircleShape)
            )

            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.color_palette3))
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Icon",
                    tint = colorResource(id = R.color.color_palette1),
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }

        CustomText(
            text = "Aditya Yoga",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = ColorPalette4,
            modifier = Modifier
                .padding(top = 10.dp)
        )

        CustomText(
            text = "DK 2938 ACL",
            fontWeight = FontWeight.Medium,
            fontSize = 11.2.sp,
            color = ColorPalette4,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 20.dp)
        )
        SettingsSection {
            navController.navigate(it) {
                restoreState = true
                launchSingleTop = true
            }
        }
    }
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
        CustomText(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = ColorPalette4,
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Icon Setting",
            tint = colorResource(id = R.color.color_palette3)
        )
    }
}

@Preview(name = "Profile")
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}
