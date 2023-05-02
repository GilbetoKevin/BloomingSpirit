package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Inicio : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private  var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var butPerfil=findViewById<Button>(R.id.but_perfil)
        var butHabitos=findViewById<Button>(R.id.textViewRosa)
        var butFitness=findViewById<Button>(R.id.textViewAzul)

        butPerfil.setOnClickListener{
            val intento1 = Intent(this,Perfil::class.java)
            startActivity(intento1)
        }
        butFitness.setOnClickListener{
            val intento1 = Intent(this,Fitness::class.java)
            startActivity(intento1)
        }
        butHabitos.setOnClickListener {
            val intent = Intent(this, HabitosRutinas::class.java)
            startActivity(intent)
        }
    }

}