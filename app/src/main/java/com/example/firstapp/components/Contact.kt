package com.example.firstapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.R

@Composable
fun Contact(name: String, phone: String){
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Contact img",
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = phone,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
}