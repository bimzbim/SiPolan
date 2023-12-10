package com.gatenzteam.sipolan.ui.screen.edit_akun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun EditAkunScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ) {
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
                    .background(ColorPalette3)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icon",
                    tint = ColorPalette1,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        CustomTextField(
            value = name,
            onValueChange = { name = it },
            label = "Nama",
            singleLine = true,
            placeholder = "Masukkan Nama Baru",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = null,
                    tint = ColorPalette3
                )
            },
            modifier = modifier
        )
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            singleLine = true,
            placeholder = "Masukkan Email Baru",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    tint = ColorPalette3
                )
            },
            modifier = modifier
        )
        CustomText(
            text = "Ingin Mengganti Password?",
            style = TextStyle(
                fontSize = 14.83.sp,
                fontWeight = FontWeight.Normal,
                color = ColorPalette4,
            ),
            modifier = modifier
                .padding(top = 25.dp, bottom = 5.dp)
        )
        CustomText(
            text = "Ganti Password",
            style = TextStyle(
                fontSize = 14.83.sp,
                fontWeight = FontWeight.Bold,
                color = ColorPalette3
            ),
            modifier = modifier.clickable {
                navController.navigate(Screen.GantiPassword.route)
            }
        )
    }
}

