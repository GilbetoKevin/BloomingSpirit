package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Fitness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness)


        var butEjercio=findViewById<Button>(R.id.buttonEjercicio)
        var butCorredor=findViewById<Button>(R.id.buttonCorredor)
        var butRespiracion=findViewById<Button>(R.id.buttonRespiracion)

        var butHome=findViewById<Button>(R.id.but_home)

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        butEjercio.setOnClickListener{
            val intent = Intent(this,Ejercicio::class.java)
            startActivity(intent)
        }

        butCorredor.setOnClickListener{
            val intent = Intent(this,Corredor::class.java)
            startActivity(intent)
        }

        butRespiracion.setOnClickListener{
            val intent = Intent(this,Respiracion::class.java)
            startActivity(intent)
        }


    }
}