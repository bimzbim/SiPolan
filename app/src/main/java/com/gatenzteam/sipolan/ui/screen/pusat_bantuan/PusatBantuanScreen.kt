@file:OptIn(ExperimentalMaterial3Api::class)

package com.gatenzteam.sipolan.ui.screen.pusat_bantuan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PusatBantuanScreen(
    modifier: Modifier = Modifier
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val bantuanList by rememberSaveable { mutableStateOf(listOf(KategoriBantuan(1, "Pelanggaran tidak Valid"), KategoriBantuan(2, "Lainnya")))}
    var selectIdKategori by rememberSaveable { mutableStateOf(0) }
    var selectKategori by rememberSaveable { mutableStateOf("") }
    var textMessage by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ColorPalette1)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {isExpanded = it},
            modifier = modifier.padding(bottom = 20.dp),
        ) {
            CustomTextField(
                value = selectKategori,
                onValueChange = {},
                readOnly = true,
                placeholder = "Pilih Kategori Bantuan",
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                }
                ,
                modifier = modifier
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
            ) {
                bantuanList.forEach {
                    DropdownMenuItem(
                        text = { CustomText(text = it.kategori, fontSize = 14.83.sp) },
                        onClick = {
                            selectIdKategori = it.id
                            selectKategori = it.kategori
                            isExpanded = false
                        }
                    )
                }
            }
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = ColorPalette2, shape = RoundedCornerShape(15.dp))
        ) {
            Column (
                modifier = modifier.padding(15.dp)
            ){
                CustomText(
                    text = "Format Penulisan Pesan : ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.83.sp,
                    color = ColorPalette3,
                    modifier = modifier.padding(bottom = 10.dp)
                )

                if(selectIdKategori == 1){
                    CustomText(
                        text = "ID Pelanggaran : {ID Pelanggaran}\n" +
                                "Kendala : {Informasikan Kendala yang terjadi}",
                        fontSize = 13.sp,
                        color = ColorPalette4
                    )
                } else {
                    CustomText(
                        text = "Kendala : {Informasikan Kendala yang terjadi}",
                        fontSize = 13.sp,
                        color = ColorPalette4
                    )
                }
            }
        }
        CustomTextField(
            value = textMessage,
            onValueChange = {
                textMessage = it
            },
            placeholder = "Masukan Pesan",
            singleLine = false,
            modifier = modifier
                .height(200.dp)
                .padding(top = 15.dp)
        )
    }
}