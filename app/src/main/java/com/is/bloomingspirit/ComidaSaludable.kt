package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ComidaSaludable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comida_saludable)
        val butRegresar=findViewById<Button>(R.id.button5)
        val butDietas=findViewById<Button>(R.id.but_dietas)
        val butHome=findViewById<Button>(R.id.but_home)

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
        butRegresar.setOnClickListener{
            val intent = Intent(this,HabitosRutinas::class.java)
            startActivity(intent)
        }
        butDietas.setOnClickListener {
            val intent = Intent(this,Dietas::class.java)
            startActivity(intent)
        }
    }
}