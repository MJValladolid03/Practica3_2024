package com.marisma.practica3_2024

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Registro para debugging
        Log.d("SplashActivity", "SplashActivity iniciada")

        // Redirigir a MainActivity después de 2 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                startActivity(Intent(this, MainActivity::class.java))
                Log.d("SplashActivity", "Navegando a MainActivity")
                finish()
            } catch (e: Exception) {
                // Registro de la excepción para debugging
                Log.e("SplashActivity", "Error al navegar a MainActivity", e)
            }
        }, 2000) // 2000 milisegundos = 2 segundos
    }
}
