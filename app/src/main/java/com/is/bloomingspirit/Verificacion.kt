package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.`is`.bloomingspirit.databinding.ActivityVerificacionBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class Verificacion : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityVerificacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verificacion)
        binding = ActivityVerificacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth

        val bot_cont=findViewById<Button>(R.id.bot_continuar)
        val bot_ext=findViewById<Button>(R.id.bot_ext)
        val user= auth.currentUser

        bot_ext.setOnClickListener {
            Firebase.auth.signOut()
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        bot_cont.setOnClickListener {
            val profileUpdates = userProfileChangeRequest {
            }
            user!!.updateProfile(profileUpdates)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        if (user.isEmailVerified) {
                            reload()
                        } else {
                            Toast.makeText(this, "Por favor verifica tu correo.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser= auth.currentUser
        if (currentUser != null){
            if (currentUser.isEmailVerified){
                reload()
            }
            sentEmailverification()
        }
    }

    private fun sentEmailverification(){
        val user =auth.currentUser
        user!!.sendEmailVerification().addOnCompleteListener(this){ task ->
            Toast.makeText(this, "Se envio un correo de verificación",
                Toast.LENGTH_SHORT).show()

        }
    }
    private fun reload(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}