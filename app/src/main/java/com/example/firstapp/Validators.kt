package com.example.firstapp

fun isValidName(name: String): Boolean {
    val trimmedName = name.trim()
    return trimmedName.isNotBlank() && trimmedName.all { it.isLetter() || it.isWhitespace() }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPhoneNumber(phoneNumber: String): Boolean {
    return phoneNumber.length == 10 && phoneNumber.all { it.isDigit() }
}

fun isValidPassword(password: String, confirmPassword: String): Boolean {
    return password == confirmPassword && password.length >= 8
}