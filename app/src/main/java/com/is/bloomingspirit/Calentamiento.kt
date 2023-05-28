package com.`is`.bloomingspirit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Calentamiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calentamiento)

        val rutina1=findViewById<Button>(R.id.butRutina1)
        val rutina2=findViewById<Button>(R.id.butRutina2)
        val rutina3=findViewById<Button>(R.id.butRutina3)
        val rutina4=findViewById<Button>(R.id.butRutina4)
        val butRegresar=findViewById<Button>(R.id.but_Regresar)

        butRegresar.setOnClickListener{
            onBackPressed()
        }

        rutina4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ImeZdDAbcL4"))
            startActivity(intent)
        }

        rutina3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zykDJg8JA3Y"))
            startActivity(intent)
        }

        rutina1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=g0z0rqoSmxY"))
            startActivity(intent)
        }
        rutina2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HNORmHn16gY"))
            startActivity(intent)
        }
    }
}