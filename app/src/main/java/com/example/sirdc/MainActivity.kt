package com.example.sirdc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var buttonLogin : Button
    private lateinit var editTextPassword : EditText
    private lateinit var editTextUsername : EditText
    private lateinit var welcome : TextView
    private lateinit var welcomeTextView : TextView

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPassword = findViewById(R.id.editTextPassword)
        editTextUsername = findViewById(R.id.editTextUsername)
        welcome = findViewById(R.id.welcome)
        welcomeTextView = findViewById(R.id.welcomeTextView)
        buttonLogin = findViewById(R.id.btnLogin)

        buttonLogin.setOnClickListener{
            val receivedPassword = editTextPassword.text.toString()
            val receivedUsername = editTextUsername.text.toString()
            checkPassword(receivedPassword)
            checkUsername(receivedUsername)
        }
    }

    private fun checkPassword(receivedPassword: String){
        if(receivedPassword == "1234"){
            Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(applicationContext, "Login Unsuccessful", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkUsername(receivedUsername: String){
        if(receivedUsername == "kuda"){
            Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
            welcomeMessage(receivedUsername)
        }
        else{
            Toast.makeText(applicationContext, "Login Unsuccessful", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun welcomeMessage(receivedUsername: String?){
        val welcomeString: String = getString(R.string.welcomeTextField)
        welcome.text = "Hie, $receivedUsername"
        welcomeTextView.text = "$welcomeString, $receivedUsername"
    }
}

