package com.example.firstapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.firstapp.components.Contact
import com.example.firstapp.isValidPhoneNumber

@Composable
fun MainScreen(navController: NavController){
    val contactList = remember { mutableStateListOf<Pair<String, String>>() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier.fillMaxWidth(0.85f)
                .padding(top = 55.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SetText(
                "Mis contatos",
                25,
                FontWeight.Bold,
                Color.Black,
                modifier = Modifier.align(Alignment.Start)
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
                label = { Text("Nombre") },
                isError = name.isEmpty()
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ), visualTransformation = VisualTransformation.None,
                value = phoneNumber,
                onValueChange = {phoneNumber = it},
                label = { Text("Teléfono") },
                isError = phoneNumber.isEmpty() && !isValidPhoneNumber(phoneNumber)
            )

            // Add contact button
            Button(
                onClick = {
                    if (name.isNotEmpty() && phoneNumber.isNotEmpty() && isValidPhoneNumber(phoneNumber)) {
                        contactList.add(Pair(name, phoneNumber))
                        name = ""
                        phoneNumber = ""
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3642B1),
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color(0xFF3642B1),
                ),
                border = BorderStroke(1.dp, Color(0xFF3642B1))
            ){
                Text("Agregar Contacto", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            // Clear button
            Button(
                onClick = {
                    name = ""
                    phoneNumber = ""
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE7E7E7),
                    contentColor = Color.DarkGray
                ),
                border = BorderStroke(1.dp, Color(0xFFE7E7E7))
            ){
                Text("Limpiar Campos", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            SetText(
                "LISTA DE CONTACTOS",
                15,
                FontWeight.Bold,
                Color.Black,
                modifier = Modifier.align(Alignment.Start)
                    .padding(top = 20.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(contactList.size) { index ->
                    val contact = contactList[index]
                    Contact(name = contact.first, phone = contact.second)
                }
            }
        }
    }
}

