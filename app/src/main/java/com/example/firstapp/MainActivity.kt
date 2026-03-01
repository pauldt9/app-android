package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
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
                        SetText("Hello", 40,
                            FontWeight.Bold, Color.Black,
                            modifier = Modifier.padding(top = 30.dp)) // Add padding to the top
                        SetText("Welcome To Little Drop, where", 18,
                            FontWeight.Normal, Color.Gray)
                        SetText("you manage your daily tasks", 18,
                            FontWeight.Normal, Color.Gray,
                            modifier = Modifier.padding(bottom = 40.dp)) // Add padding to the bottom

                        // Login button
                        InsertButton("Login", Color(0xFF3642B1),
                            Color.White, Color(0xFF3642B1), {})

                        // Sign up button
                        InsertButton("Sign Up", Color.White,
                            Color(0xFF3642B1), Color(0xFF3642B1), {})

                        SetText("Sign up using", 12, FontWeight.Normal,
                            Color.Gray, modifier = Modifier.padding(top = 40.dp))

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
        }
    }
}

// Display a text on the screen
@Composable
fun SetText(newText: String, newFontSize: Int, newFontWeight: FontWeight, newColor: Color, modifier: Modifier = Modifier){
    Text(
        text = newText,
        modifier = modifier,
        style = TextStyle(
            fontSize = newFontSize.sp,
            fontWeight = newFontWeight,
            color = newColor
        )
    )
}

// Display a button on the screen
@Composable
fun InsertButton(label: String, bgColor: Color, fontColor: Color, borderColor: Color, onClick: () -> Unit){
    Box(
        modifier = Modifier.fillMaxWidth(0.8f)
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(30.dp)) // Apply rounded corners
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(30.dp)
            )
            .background(
                color = bgColor,
                shape = RoundedCornerShape(30.dp)
            )
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = fontColor, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}