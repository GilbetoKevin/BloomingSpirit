package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ejercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio)

        var butHome = findViewById<Button>(R.id.but_home)
        var butRegresar = findViewById<Button>(R.id.but_Regresar)
        var butNoti = findViewById<Button>(R.id.but_Noti)
        var butCalentamiento = findViewById<Button>(R.id.but_Calentamiento)
        var butEjerciciosGuiados = findViewById<Button>(R.id.but_EjerciciosGuiados)

        butHome.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
        butNoti.setOnClickListener {
            val intent = Intent(this, Notificacion::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

            butRegresar.setOnClickListener {
                onBackPressed()
            }
        }
        butCalentamiento.setOnClickListener {
            val intent= Intent(this, Calentamiento::class.java)
            startActivity(intent)
        }
        butEjerciciosGuiados.setOnClickListener {
            val intent= Intent(this, EjerciciosGuiados::class.java)
            startActivity(intent)
        }
    }
}