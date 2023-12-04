package com.gatenzteam.sipolan.ui.screen.detail_bayar

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.colorpalette1
import com.gatenzteam.sipolan.ui.theme.colorpalette2
import com.gatenzteam.sipolan.ui.theme.colorpalette3
import com.gatenzteam.sipolan.ui.theme.colorpalette4
import com.google.android.gms.wallet.button.ButtonConstants

@Composable
fun DetailBayarScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorpalette1)
            .padding(5.dp)
    ){
        val paymentDetails = DataDetailBayar.dummy
        DetailBayarContent(
            id = paymentDetails.id,
            jenis = paymentDetails.jenis,
            biaya = paymentDetails.biaya,
            tanggal = paymentDetails.tanggal,
            metode = paymentDetails.metode,
            status = paymentDetails.status,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = {
                navController.navigate(Screen.MetodePembayaran.route)
            }
        )
    }
}

@Composable
fun DetailBayarContent(
    id: String,
    jenis: String,
    biaya: String,
    tanggal: String,
    metode: String,
    status: Boolean,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .background(color = colorpalette2, shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = jenis,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.1.sp,
                    color = colorpalette3
                )
                Text(
                    text = biaya,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.1.sp
                )
            }

            Column(
                modifier = Modifier
                    .width(62.dp)
                    .height(23.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = if (status) colorpalette3 else Color.Red,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (status) "Sukses" else "Gagal",
                        color = if(status) colorpalette1 else colorpalette4,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Kode Pembayaran",
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = colorpalette4
        )

        Text(
            text = id,
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 11.1.sp,
            color = colorpalette4
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Metode Pembayaran",
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = colorpalette4
        )

        Text(
            text = metode,
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 11.1.sp,
            color = colorpalette4
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tanggal Pembayaran",
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = colorpalette4
        )

        Text(
            text = tanggal,
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 11.1.sp,
            color = colorpalette4
        )
    }
}

@Composable
fun NextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        colors = ButtonDefaults.buttonColors(
            colorpalette3
        ),
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(text = "Next",
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Bold,
            color = colorpalette1)
    }
}
