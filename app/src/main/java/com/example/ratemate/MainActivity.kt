package com.example.ratemate

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signupButton = findViewById<Button>(R.id.signupButton)

        // Handle signup button click
        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validate inputs
            when {
                TextUtils.isEmpty(username) -> {
                    usernameEditText.error = "Username is required"
                }
                TextUtils.isEmpty(email) -> {
                    emailEditText.error = "Email is required"
                }
                TextUtils.isEmpty(password) -> {
                    passwordEditText.error = "Password is required"
                }
                password.length < 6 -> {
                    passwordEditText.error = "Password must be at least 6 characters"
                }
                else -> {
                    // Show success message for the prototype
                    Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
