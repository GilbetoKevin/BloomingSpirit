package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NochesRelajantes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noches_relajantes)

        var butHome=findViewById<Button>(R.id.but_home)
        var butPerfil=findViewById<Button>(R.id.but_perfil)
        var butRegresar=findViewById<Button>(R.id.but_Regresar)

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }

        butPerfil.setOnClickListener{
            val intent = Intent(this,Perfil::class.java)
            startActivity(intent)
        }

        butRegresar.setOnClickListener{
            val intent = Intent(this,HabitosRutinas::class.java)
            startActivity(intent)
        }
    }
}