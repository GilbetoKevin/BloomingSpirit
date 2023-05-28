package com.`is`.bloomingspirit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EjerciciosRespiracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios_respiracion)

        val rutina1=findViewById<Button>(R.id.butRutina1)
        val rutina2=findViewById<Button>(R.id.butRutina2)
        val butRegresar=findViewById<Button>(R.id.but_Regresar)
        val butHome=findViewById<Button>(R.id.but_home)

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        butRegresar.setOnClickListener{
            onBackPressed()
        }

        rutina1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0dyebB9e-vM"))
            startActivity(intent)
        }
        rutina2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=m1ykgSwgKKs"))
            startActivity(intent)
        }

    }

}