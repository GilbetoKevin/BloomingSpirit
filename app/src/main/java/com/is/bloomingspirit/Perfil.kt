package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.`is`.bloomingspirit.databinding.ActivityPerfilBinding


class Perfil : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    private lateinit var auth: FirebaseAuth
    private  var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        var nombre:String="";
        var fecha:String="";
        var text1=findViewById<TextView>(R.id.textTest)
        var text2=findViewById<TextView>(R.id.textTest1)
        val botExt = findViewById<Button>(R.id.bot_cerrarSesion)
        val botInicio = findViewById<Button>(R.id.but_inicio)

        botInicio.setOnClickListener{
            val intento1 = Intent(this,Inicio::class.java)
            startActivity(intento1)
        }

        botExt.setOnClickListener {
            singOut()
        }
        FirebaseAuth.getInstance().currentUser?.let { user ->
            val email = user.email


            db.collection("users").document(email.toString()).get().addOnSuccessListener { document ->
                if(document.exists()){
                    nombre=document.data?.get("usuario").toString()
                    fecha=document.data?.get("fecha").toString()
                    text1.setText(nombre)
                    text2.setText(fecha )
                }else{
                    text1.setText("no se encotro")
                }

            }
        } ?: run {
            // User is signed out
            // ...
        }

    }
    private fun singOut(){
        Firebase.auth.signOut()
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}