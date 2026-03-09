package com.example.firstapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstapp.InsertButton
import com.example.firstapp.InsertTextField
import com.example.firstapp.R
import com.example.firstapp.SetText

@Composable
fun LoginScreen(navController: NavController){
    Column(
        Modifier.fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column(
            Modifier.fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login2),
                contentDescription = "Login img 2",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(250.dp)
            )

            SetText(
                "Login",
                40,
                FontWeight.Bold,
                Color.Black
            )

            InsertTextField("Name", false, modifier = Modifier.fillMaxWidth())
            InsertTextField("Email", false, modifier = Modifier.fillMaxWidth())
            InsertTextField("Password", true, modifier = Modifier.fillMaxWidth())

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                SetText(
                    "Forgot password?",
                    14,
                    FontWeight.Normal,
                    Color.Gray
                )
            }

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                InsertButton(
                    "Log in",
                    Color(0xFF3642B1),
                    Color.White,
                    Color(0xFF3642B1),
                    modifier = Modifier.fillMaxWidth(0.35f)
                ) { navController.navigate("home") }
            }
        }
    }
}