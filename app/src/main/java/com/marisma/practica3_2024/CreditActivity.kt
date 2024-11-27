package com.marisma.practica3_2024

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Obtener el nombre del usuario del Intent que lanzó esta actividad
        val userName = intent.getStringExtra("USER_NAME")
        val appName = getString(R.string.app_name) // Nombre de la app desde recursos

        // Configurar el TextView para mostrar el mensaje
        val infoTextView = findViewById<TextView>(R.id.infoTextView)
        if (userName != null && userName.isNotEmpty()) {
            infoTextView.text = "Usuario $userName, estás usando la versión 1 de $appName"
        } else {
            infoTextView.text = "No se proporcionó un nombre de usuario."
        }

        // Añadir una pequeña descripción
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        descriptionTextView.text = "La aplicacion trata de temas de musica en el cual vamso a cononcer mas sobre el cantante sus discos años etc"

        // Configurar el botón "Contactar"
        val contactButton = findViewById<Button>(R.id.contactButton)
        contactButton.setOnClickListener {
            // Configurar el intent implícito para enviar correo electrónico
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:mvalcar1711@g.educaand.es")
                putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app $appName")
            }

            // Verificar que hay una aplicación que pueda manejar el intent
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                // Mostrar un mensaje de error si no hay ninguna aplicación de correo instalada
                Toast.makeText(this@CreditActivity, "No hay ninguna aplicación de correo instalada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
