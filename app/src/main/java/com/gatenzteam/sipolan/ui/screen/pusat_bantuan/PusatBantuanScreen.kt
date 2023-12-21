@file:OptIn(ExperimentalMaterial3Api::class)

package com.gatenzteam.sipolan.ui.screen.pusat_bantuan

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette2
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.utils.PusatBantuanViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PusatBantuanScreen(
    modifier: Modifier = Modifier,
    viewModel: PusatBantuanViewModel = viewModel(
        factory = PusatBantuanViewModelFactory(Injection.providePusatBantuanRepository())
    ),
) {
    val kategoriBantuanState by viewModel.kategoriBantuanState.collectAsState()
    val messageState by viewModel.messageState.collectAsState()
    viewModel.getKategoriBantuan()

    var isExpanded by rememberSaveable { mutableStateOf(false) }
    var selectIdKategori by rememberSaveable { mutableStateOf(0) }
    var selectKategori by rememberSaveable { mutableStateOf("") }
    var textMessage by rememberSaveable { mutableStateOf("") }
    var alreadySend by rememberSaveable { mutableStateOf(true) }

    val bantuanList = when (kategoriBantuanState) {
        is ResultState.Success -> {
            val kategoriBantuanList = (kategoriBantuanState as ResultState.Success).data.data
            kategoriBantuanList.map { KategoriBantuan(it.categoryId, it.categoryName) }
        }
        else -> listOf(KategoriBantuan(1, "Opsi 1"), KategoriBantuan(2, "Opsi 2"))
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it },
            modifier = modifier.padding(bottom = 20.dp),
        ) {
            CustomTextField(
                value = selectKategori,
                onValueChange = {},
                readOnly = true,
                placeholder = stringResource(R.string.bantuan_kategori),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = modifier.menuAnchor()
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
                    text = stringResource(R.string.bantuan_format),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.83.sp,
                    color = ColorPalette3,
                    modifier = modifier.padding(bottom = 10.dp)
                )

                if(selectIdKategori == 1){
                    CustomText(
                        text = stringResource(R.string.bantuan_opsi1),
                        fontSize = 13.sp,
                        color = ColorPalette4
                    )
                } else {
                    CustomText(
                        text = stringResource(R.string.bantuan_opsi2),
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
            placeholder = stringResource(R.string.bantuan_pesan),
            singleLine = false,
            modifier = modifier
                .height(200.dp)
                .padding(top = 15.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            colors = ButtonDefaults.buttonColors(
                ColorPalette3
            ),
            onClick = {
                alreadySend = false
                val message = textMessage
                viewModel.sendMessage(1, selectIdKategori, message)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier
            ){
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = "Icon",
                    tint = ColorPalette1,
                    modifier = Modifier
                        .fillMaxHeight()
                )

                CustomText(
                    text = "Kirim",
                    fontSize = 15.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    color = ColorPalette1,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 10.dp)
                )
            }

        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ){
        when(messageState){
            is ResultState.Success -> {
                val messageResponse = (messageState as ResultState.Success).data
                Toast.makeText(LocalContext.current, messageResponse.message, Toast.LENGTH_SHORT).show()

                alreadySend = true
            }
            is ResultState.Error -> {
                val errorResponse = (messageState as ResultState.Error).error
                Toast.makeText(LocalContext.current, errorResponse, Toast.LENGTH_SHORT).show()

                alreadySend = true
            }
            is ResultState.Loading -> {
                if (!alreadySend) {
                    CircularProgressIndicator(
                        color = ColorPalette3,
                        strokeWidth = 3.dp,
                        modifier = Modifier
                            .padding(25.dp)
                            .size(40.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}