package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Respiracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracion)

        var butHome=findViewById<Button>(R.id.but_home)
        var butNoti=findViewById<Button>(R.id.but_Noti)
        var butRegresar=findViewById<Button>(R.id.but_Regresar)
        var butEjerciciosRespiracion=findViewById<Button>(R.id.but_EjerciciosRespiracion)



        butEjerciciosRespiracion.setOnClickListener{
            val intent = Intent(this,EjerciciosRespiracion::class.java)

            startActivity(intent)

        }
        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
        butNoti.setOnClickListener{
            val intent = Intent(this,Notificacion::class.java)
            intent.putExtra("titulo", "Es hora de Respirar Correctamente ")
            intent.putExtra("context", "Programaste tus ejercicios de respiración a esta hora")
            intent.putExtra("bigText", "Los ejercicios de respiración son beneficiosos para reducir el estrés, mejorar la concentración, promover la relajación, aumentar la capacidad pulmonar y mejorar la oxigenación del cuerpo.")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        butRegresar.setOnClickListener{
            onBackPressed()
        }
    }
}