package com.`is`.bloomingspirit

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class EjerciciosGuiados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios_guiados)
        val rutina1=findViewById<Button>(R.id.butRutina1)
        val rutina2=findViewById<Button>(R.id.butRutina2)
        val rutina3=findViewById<Button>(R.id.butRutina3)
        val rutina4=findViewById<Button>(R.id.butRutina4)

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

        rutina4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sZGM7pLR18g"))
            startActivity(intent)
        }

        rutina3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0VvNNIt1c_Q"))
            startActivity(intent)
        }

        rutina1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=y9-_6xBgJbE"))
            startActivity(intent)
        }
        rutina2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9v3uFEAL7Ys"))
            startActivity(intent)
        }



    }
}