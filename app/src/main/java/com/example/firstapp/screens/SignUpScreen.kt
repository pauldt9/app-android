package com.example.firstapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapp.InsertButton
import com.example.firstapp.InsertTextField
import com.example.firstapp.SetText

@Composable
fun SignUpScreen(navController: NavController){
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
            SetText(
                "Sign Up",
                40,
                FontWeight.Bold,
                Color.Black
            )

            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var phoneNumber by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            fun isValidName(name: String): Boolean {
                return name.isNotBlank() && name.all { it.isLetter() }
            }

            fun isValidEmail(email: String): Boolean {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }

            fun isValidPhoneNumber(phoneNumber: String): Boolean {
                return phoneNumber.length == 10 && phoneNumber.all { it.isDigit() }
            }

            fun isValidPassword(password: String, confirmPassword: String): Boolean {
                return password == confirmPassword
            }

            // Name text field
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ), visualTransformation = VisualTransformation.None,
                value = name,
                onValueChange = {name = it},
                label = { Text("Name") }
            )

            // Email text field
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ), visualTransformation = VisualTransformation.None,
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("Email") }
            )

            // Phone number text field
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ), visualTransformation = VisualTransformation.None,
                value = phoneNumber,
                onValueChange = {phoneNumber = it},
                label = { Text("Phone Number") }
            )

            // Password text field
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ), visualTransformation = PasswordVisualTransformation(),
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") }
            )

            // Confirm password text field
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ), visualTransformation = PasswordVisualTransformation(),
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = { Text("Confirm Password") }
            )

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                InsertButton(
                    "Sign Up",
                    Color(0xFF3642B1),
                    Color.White,
                    Color(0xFF3642B1),
                    modifier = Modifier.fillMaxWidth(0.35f)
                ) { navController.navigate("login") }
            }
        }
    }
}

