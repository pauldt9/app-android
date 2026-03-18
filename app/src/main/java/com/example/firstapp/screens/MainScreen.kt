package com.example.firstapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapp.SetText

@Composable
fun MainScreen(navController: NavController){
    val contactList = remember { mutableStateListOf<Pair<String, String>>() }

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetText(
            "Mis contctos",
            20,
            FontWeight.Bold,
            Color.Black
        )

        var name by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 18.sp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ), visualTransformation = VisualTransformation.None,
            value = name,
            onValueChange = {name = it},
            label = { Text("Name") },
            isError = name.isNotEmpty()
        )

        LazyColumn() {

        }
    }


}

