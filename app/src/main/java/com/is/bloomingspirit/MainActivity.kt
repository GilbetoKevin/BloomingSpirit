package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

import com.`is`.bloomingspirit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        var boton1=findViewById<Button>(R.id.bot_acceder)
        var boton2=findViewById<Button>(R.id.bot_acceder2)
        var text1=findViewById<EditText>(R.id.editTextUsuario)
        var text2=findViewById<EditText>(R.id.editTextTextPassword3)
        var botonRecuperacion=findViewById<Button>(R.id.bot_recuperacion)

        botonRecuperacion.setOnClickListener{
            val intento1 = Intent(this,RecuperacionContra::class.java)
            startActivity(intento1)
        }


        boton1.setOnClickListener{
            val mEmail = text1.text.toString()
            val mPassword =text2.text.toString()


            if(mEmail.isEmpty() && mPassword.isEmpty()) {
                Toast.makeText(baseContext, "Los campos de Correo y contraseña estan vacíos",
                    Toast.LENGTH_SHORT).show()
            }else if(mEmail.isEmpty()){
                Toast.makeText( baseContext, "El campo de Correo esta vacío",
                    Toast.LENGTH_SHORT).show()
            }else if(mPassword.isEmpty()){
                Toast.makeText( baseContext, "El campo de contraseña esta vacío",
                    Toast.LENGTH_SHORT).show()
            }else {
                SingIn(mEmail,mPassword)
            }
        }

        boton2.setOnClickListener {
        val intento1= Intent(this,Registro::class.java)
        startActivity(intento1)
        }
    }



    public override fun onStart() {
        super.onStart()
        val currentUser= auth.currentUser
        if (currentUser != null){
            if (currentUser.isEmailVerified){
                reaload()
            }else{
                val intent=Intent(this,Verificacion::class.java)
                startActivity(intent)
            }

        }
    }
    private fun SingIn(usuario : String, password: String ){
        auth.signInWithEmailAndPassword(usuario, password).
        addOnCompleteListener(this){ task ->
            if(task.isSuccessful){
                onStart()
            }else {
                Log.w("TAG", "singInWithEmail:failure",task.exception)
                Toast.makeText(baseContext, "Correo o Contraseña Incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun reaload(){
        val intent = Intent (this, Inicio::class.java)
        this.startActivity(intent)
    }
}