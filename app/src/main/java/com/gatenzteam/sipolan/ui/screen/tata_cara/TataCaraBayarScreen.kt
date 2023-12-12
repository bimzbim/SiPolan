package com.gatenzteam.sipolan.ui.screen.tata_cara

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun TataCaraBayarScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ){
        Box(
            modifier = modifier
                .background(ColorPalette2, shape = RoundedCornerShape(15.dp))
                .fillMaxWidth()
        ){
            Column(
                modifier = modifier.padding(20.dp)
            ){
                CustomText(
                    text = "Kode Virtual Account",
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.1.sp,
                    color = ColorPalette4
                )
                CustomText(
                    text = "36345 082863662123",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = ColorPalette3
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        CustomText(
            text = "1. Buka Aplikasi M Bankingmu\n" +
                    "2. Masuk ke Menu Transfer > Virtual Account\n" +
                    "3. Masukan No Virtual Account diatas\n" +
                    "4. Konfirmasi Informasi Tagihan\n" +
                    "5. Masukan Pin M-Bankingmu untuk melakukan Pembayaran",
            fontWeight = FontWeight.Normal,
            //textAlign = TextAlign.Justify,
            fontSize = 11.sp,
            color = ColorPalette4,
            modifier = modifier
                .padding(10.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            colors = ButtonDefaults.buttonColors(
                ColorPalette3
            ),
            onClick = {
                navController.navigate(Screen.Home.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        ) {
            Text(text = "Konfirmasi Pembayaran",
                fontFamily = Poppins.poppinsFamily,
                fontWeight = FontWeight.Bold,
                color = ColorPalette1)
        }
    }
}

