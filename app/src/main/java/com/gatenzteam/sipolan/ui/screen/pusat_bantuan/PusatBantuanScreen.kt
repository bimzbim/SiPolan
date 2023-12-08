@file:OptIn(ExperimentalMaterial3Api::class)

package com.gatenzteam.sipolan.ui.screen.pusat_bantuan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@Composable
fun PusatBantuanScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(ColorPalette1)
    ){
        Box(
            modifier = Modifier.padding(25.dp)
        ){
            Column {
                KategoriDropdownMenu()
                Spacer(Modifier.height(10.dp))
                PesanTextArea()
                Spacer(Modifier.height(20.dp))
                FormatSection()
            }
        }
    }
}

@Composable
fun KategoriDropdownMenu(
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    val bantuanList by remember { mutableStateOf(listOf("Pembayaran", "Konfirmasi", "Lainnya"))}
    var pilihan by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = {isExpanded = it},
    ) {
        OutlinedTextField(
            value = pilihan,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors =  textFieldColors(
                unfocusedContainerColor = ColorPalette1,
                focusedContainerColor = ColorPalette1,
                unfocusedTrailingIconColor = ColorPalette3,
                focusedTrailingIconColor = ColorPalette3,
                unfocusedIndicatorColor = ColorPalette2,
                focusedIndicatorColor = ColorPalette2,
                unfocusedTextColor = ColorPalette3,
                focusedTextColor = ColorPalette3
            ),
            textStyle = TextStyle(fontFamily = Poppins.poppinsFamily, fontWeight = FontWeight.Normal, fontSize = 14.83.sp),
            shape = RoundedCornerShape(15.dp),
            modifier = modifier
                .menuAnchor()
                .fillMaxWidth(),
            label = { Text(text = "Kategori Bantuan", fontFamily = Poppins.poppinsFamily, fontWeight = FontWeight.Light, color = ColorPalette4) },
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            bantuanList.forEach {
                DropdownMenuItem(
                    text = {Text(it, fontFamily = Poppins.poppinsFamily, fontWeight = FontWeight.Normal, fontSize = 14.83.sp)},
                    onClick = {
                        pilihan = it
                        isExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun PesanTextArea(
    modifier: Modifier = Modifier
){
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            colors = textFieldColors(
                unfocusedContainerColor = ColorPalette1,
                focusedContainerColor = ColorPalette1,
                unfocusedIndicatorColor = ColorPalette2,
                focusedIndicatorColor = ColorPalette2,
                unfocusedTextColor = ColorPalette3,
                focusedTextColor = ColorPalette3
            ),
            shape = RoundedCornerShape(15.dp),
            label = { Text("Pesan", fontFamily = Poppins.poppinsFamily, fontWeight = FontWeight.Light, color = ColorPalette4) },
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Composable
fun FormatSection(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = ColorPalette2, shape = RoundedCornerShape(15.dp))
    ) {
        Column (
            modifier = modifier.padding(15.dp)
        ){
            Text(
                text = "Isikan kolom pesan dengan format seperti berikut: ",
                fontFamily = Poppins.poppinsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.83.sp,
                color = ColorPalette3
            )

            Spacer(modifier.height(10.dp))

            Text(
                text = "ID Pembayaran: (Isikan sendiri)",
                fontFamily = Poppins.poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 11.1.sp,
                color = ColorPalette4
            )
            Text(
                text = "ID Pembayaran: (Isikan sendiri)",
                fontFamily = Poppins.poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 11.1.sp,
                color = ColorPalette4
            )
            Text(
                text = "ID Pembayaran: (Isikan sendiri)",
                fontFamily = Poppins.poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 11.1.sp,
                color = ColorPalette4
            )
        }
    }
}