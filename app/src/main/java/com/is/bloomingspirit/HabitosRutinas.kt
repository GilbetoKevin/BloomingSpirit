package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HabitosRutinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habitos_rutinas)
        var butHome=findViewById<Button>(R.id.but_home)

        var butNoches=findViewById<Button>(R.id.buttonNoche)
        var butMeditar=findViewById<Button>(R.id.buttonMedita)
        var butComida=findViewById<Button>(R.id.buttonComida)

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }



        butNoches.setOnClickListener{
            val intent = Intent(this,NochesRelajantes::class.java)
            startActivity(intent)
        }

        butMeditar.setOnClickListener{
            val intent = Intent(this,Meditacion::class.java)
            startActivity(intent)
        }
        butComida.setOnClickListener{
            val intent = Intent(this,ComidaSaludable::class.java)
            startActivity(intent)
        }
    }
}