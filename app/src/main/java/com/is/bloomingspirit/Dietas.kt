package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Dietas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietas)
        var butHome=findViewById<Button>(R.id.but_home)
        var butRegresar=findViewById<Button>(R.id.but_Regresar)

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }
        butRegresar.setOnClickListener{
            val intent = Intent(this,HabitosRutinas::class.java)
            startActivity(intent)
        }
    }
}