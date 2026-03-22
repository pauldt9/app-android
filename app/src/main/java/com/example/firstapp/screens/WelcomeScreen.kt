package com.example.firstapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.firstapp.R
import com.example.firstapp.SetText

@Composable
fun WelcomeScreen(navController: NavController){
    // Main container
    Box(
        Modifier.fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center // Align all elements in the center
    ){
        // Elements container
        Column(
            Modifier.fillMaxWidth(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_img),
                contentDescription = "Login img",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(300.dp)
            )

            // Text
            SetText(
                "Hello", 40,
                FontWeight.Bold, Color.Black,
                modifier = Modifier.padding(top = 30.dp)
            ) // Add padding to the top
            SetText(
                "Welcome To Little Drop, where", 18,
                FontWeight.Normal, Color.Gray
            )
            SetText(
                "you manage your daily tasks", 18,
                FontWeight.Normal, Color.Gray,
                modifier = Modifier.padding(bottom = 40.dp)
            ) // Add padding to the bottom

            // Login button
            InsertButton(
                "Login",
                Color(0xFF3642B1),
                Color.White,
                Color(0xFF3642B1),
                modifier = Modifier.fillMaxWidth(0.8f)
            ) { navController.navigate("login") } // Show login screen

            // Sign up button
            InsertButton(
                "Sign Up",
                Color.White,
                Color(0xFF3642B1),
                Color(0xFF3642B1),
                modifier = Modifier.fillMaxWidth(0.8f)
            ) { navController.navigate("signup") } // Show sign up screen

            SetText(
                "Sign up using", 12, FontWeight.Normal,
                Color.Gray, modifier = Modifier.padding(top = 40.dp)
            )

            // Social media container
            Row (
                Modifier.fillMaxWidth(0.6f)
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Center, // Center the elements horizontally
                verticalAlignment = Alignment.CenterVertically
            ){
                // Facebook logo
                Image(
                    painter = painterResource(id = R.drawable.fb_img),
                    contentDescription = "Facebook",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(horizontal = 10.dp)
                        .size(45.dp)
                )

                // Google+ logo
                Image(
                    painter = painterResource(id = R.drawable.gplus_img),
                    contentDescription = "Google Plus",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(40.dp)
                )

                // LinkedIn logo
                Image(
                    painter = painterResource(id = R.drawable.linkedin_img),
                    contentDescription = "LinkedIn",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(horizontal = 10.dp)
                        .size(40.dp)
                )
            }
        }
    }
}