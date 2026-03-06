package com.example.firstapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
fun InsertButton(label: String, bgColor: Color, fontColor: Color, borderColor: Color, modifier: Modifier,onClick: () -> Unit){
    Box(
        modifier = modifier
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

// Create a text field
@Composable
fun InsertTextField(label: String, isPassword: Boolean = false, modifier: Modifier = Modifier){
    val text = remember {mutableStateOf("")} // Store the text value so it doesn't reset when the UI recomposes
    OutlinedTextField(
        modifier = modifier,
        textStyle = TextStyle(fontSize = 18.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text // Set the keyboard type
        ), visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None, // Hide the password
        value = text.value, // Current text displayed in the text field.
        onValueChange = {text.value = it}, // Save the new text (it = new text).
        label = { Text(label) }
    )
}