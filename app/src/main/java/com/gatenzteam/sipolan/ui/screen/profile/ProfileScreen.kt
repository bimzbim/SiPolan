package com.gatenzteam.sipolan.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.font.Poppins

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            ){
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Icon",
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.Center)
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

        Spacer(modifier = Modifier.height(25.dp))
        SettingItem(text = "Edit Akun")
        SettingItem(text = "Riwayat Pembayaran")
        SettingItem(text = "Pelanggaran Saya")
        SettingItem(text = "Pusat Bantuan")
    }
}

@Composable
fun SettingItem(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
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
    ProfileScreen()
}
