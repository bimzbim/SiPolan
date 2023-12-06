package com.gatenzteam.sipolan.ui.screen.pusat_bantuan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.colorpalette1
import com.gatenzteam.sipolan.ui.theme.colorpalette2
import com.gatenzteam.sipolan.ui.theme.colorpalette3
import com.gatenzteam.sipolan.ui.theme.colorpalette4

@Composable
fun PusatBantuanScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(colorpalette1)
    ){
        KategoriDropdownMenu()
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun KategoriDropdownMenu(
//    modifier: Modifier
//){
//    var expanded by remember { mutableStateOf(false) }
//    val genderList by remember { mutableStateOf(listOf("Male", "Female")) }
//    var textFieldSize by remember { mutableStateOf(Size.Zero) }
//
//    val icon = if (expanded)
//        Icons.Filled.ArrowDropUp
//    else
//        Icons.Filled.ArrowDropDown
//
//    ExposedDropdownMenuBox(
//        modifier = modifier
//            .clickable(onClick = { expanded = true }),
//        expanded = expanded,
//        onExpandedChange = { expanded = !expanded }
//    ) {
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            modifier = Modifier
//                .fillMaxWidth()
//                .onGloballyPositioned { coordinates ->
//                    textFieldSize = coordinates.size.toSize()
//                },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = colorpalette1,
//                unfocusedIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = BrandColor,
//                focusedLabelColor = BrandColor,
//            ),
//            leadingIcon = {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_complete_registration_sex),
//                    contentDescription = null
//                )
//            },
//            trailingIcon = { Icon(icon, null) },
//            shape = RoundedCornerShape(Dimen.Dimen14),
//            label = {
//                Text(
//                    "Choose Gender",
//                    style = PoppinsNormalStyle14
//                )
//            },
//            readOnly = true
//        )
//
//        ExposedDropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier
//                .background(Color.White)
//                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
//        ) {
//            genderList.forEach {
//                DropdownMenuItem(
//                    onClick = { expanded = false },
//                ) {
//                    Text(it, style = PoppinsNormalStyle12Gray2)
//                }
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KategoriDropdownMenu() {
    var isExpanded by remember { mutableStateOf(false) }
    val bantuanList by remember { mutableStateOf(listOf("Pembayaran", "Konfirmasi", "Lainnya"))}

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = {isExpanded = it},
    ) {
        OutlinedTextField(
            value = "Kategori Bantuan",
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors =  ExposedDropdownMenuDefaults.textFieldColors(
                unfocusedContainerColor = colorpalette1,
                focusedContainerColor = colorpalette1,
                unfocusedTrailingIconColor = colorpalette3,
                focusedTrailingIconColor = colorpalette3,
                unfocusedIndicatorColor = colorpalette2,
                focusedIndicatorColor = colorpalette2
            ),
            textStyle = TextStyle(fontFamily = Poppins.poppinsFamily, fontWeight = FontWeight.Normal, fontSize = 14.83.sp),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.menuAnchor(),
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            bantuanList.forEach {
                DropdownMenuItem(
                    text = {Text(it, fontFamily = Poppins.poppinsFamily, fontWeight = FontWeight.Normal, fontSize = 14.83.sp)},
                    onClick = {
                        isExpanded = false
                    }
                )
            }
        }
    }
}