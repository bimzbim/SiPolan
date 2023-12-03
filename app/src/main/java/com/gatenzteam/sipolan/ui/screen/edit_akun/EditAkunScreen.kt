package com.gatenzteam.sipolan.ui.screen.edit_akun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.navigation.Screen
import com.gatenzteam.sipolan.ui.theme.colorpalette1

@Composable
fun EditAkunScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorpalette1)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            EditSection(
                onClick = {
                    navController.navigate(Screen.GantiPassword.route)
                }
            )
        }
    }
}

@Composable
fun EditSection(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

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
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Icon",
                tint = colorResource(id = R.color.color_palette1),
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
    Spacer(modifier = Modifier.height(25.dp))

    CustomTextField(
        value = name,
        onValueChange = { name = it },
        label = "Name",
        singleLine = true,
        placeholder = "Name",
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = null,
                tint = colorResource(R.color.color_palette3)
            )
        },
        modifier = modifier
    )

    CustomTextField(
        value = email,
        onValueChange = { email = it },
        label = "Email",
        singleLine = true,
        placeholder = "Email",
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
                tint = colorResource(R.color.color_palette3)
            )
        },
        modifier = modifier
    )

    Text(
        text = "Ingin Mengganti Password?",
        style = TextStyle(
            fontSize = 14.83.sp,
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.color_palette4),
        ),
        modifier = modifier
            .padding(top = 25.dp, bottom = 5.dp)
    )

    Text(
        text = "Ganti Password",
        style = TextStyle(
            fontSize = 14.83.sp,
            fontFamily = Poppins.poppinsFamily,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.color_palette3)
        ),
        modifier = modifier.clickable{
            onClick()
        }
    )
}

@Preview(name = "Edit Akun")
@Composable
fun EditAkunScreenPreview() {
    val navController = rememberNavController()
    EditAkunScreen(navController)
}

