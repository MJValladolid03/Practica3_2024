package com.marisma.practica3_2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userNameEditText = findViewById<EditText>(R.id.etNombre)
        val nextButton = findViewById<Button>(R.id.btnSiguiente)

        nextButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val intent = Intent(this, CreditActivity::class.java).apply {
                putExtra("USER_NAME", userName)
            }
            startActivity(intent)
        }
    }
}
