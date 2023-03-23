package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ComidaSaludable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comida_saludable)
        var butRegresar=findViewById<Button>(R.id.button5)

        butRegresar.setOnClickListener{
            val intent = Intent(this,HabitosRutinas::class.java)
            startActivity(intent)
        }
    }
}