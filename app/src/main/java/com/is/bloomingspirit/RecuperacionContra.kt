package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.`is`.bloomingspirit.databinding.ActivityMainBinding
import com.`is`.bloomingspirit.databinding.ActivityRecuperacionContraBinding

class RecuperacionContra : AppCompatActivity() {
    private lateinit var bining: ActivityRecuperacionContraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion_contra)
        bining= ActivityRecuperacionContraBinding.inflate(layoutInflater)
        setContentView(bining.root)
        val boton1=findViewById<Button>(R.id.bot_buscar)
        val text=findViewById<EditText>(R.id.editTextCorreo)

        boton1.setOnClickListener {
            val emailAddress= text.text.toString()
            Firebase.auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Correo enviado", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this, ActivityMainBinding::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Ingrese un email de una cuenta valida.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}