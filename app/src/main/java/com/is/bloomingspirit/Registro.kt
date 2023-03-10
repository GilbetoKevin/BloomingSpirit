package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.`is`.bloomingspirit.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class Registro : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private  var db= FirebaseFirestore.getInstance()
    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        binding= ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        auth= Firebase.auth

        var enviar=findViewById<Button>(R.id.bot_acceder)
        val email=findViewById<EditText>(R.id.editTextCorreo)
        val contra=findViewById<EditText>(R.id.editTextTextPassword)
        val contraConf=findViewById<EditText>(R.id.editTextTextPassword2)
        val usuario=findViewById<EditText>(R.id.editTextUsuario)
        val fecha=findViewById<EditText>(R.id.editTextFecha)

        enviar.setOnClickListener{

            val mEmail=email.text.toString()
            val mUser=usuario.text.toString()
            val mFecha=fecha.text.toString()
            val mPassword= contra.text.toString()
            print(mEmail)
            print(mUser)
            print(mFecha)
            print(email)
            print(mPassword)

            val mRepeatPassword=contraConf.text.toString()

            // Mínimo ocho caracteres, al menos una letra y un número:
            val passwordRegex = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
            // Formaro de fecha
            val FechaRegex = Pattern.compile("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})\$")

            if(mEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
                Toast.makeText(this, "Ingrese un email valido.",
                    Toast.LENGTH_SHORT).show()
            } else if (mPassword.isEmpty() || !passwordRegex.matcher(mPassword).matches()){
                Toast.makeText(this, "La contraseña es debil.",
                    Toast.LENGTH_SHORT).show()
            } else if (mPassword != mRepeatPassword){
                Toast.makeText(this, "Confirma la contraseña.",
                    Toast.LENGTH_SHORT).show()
            } else if(mFecha.isEmpty() || !FechaRegex.matcher(mFecha).matches()){
                Toast.makeText(this, "Formato de fecha no valido",
                    Toast.LENGTH_SHORT).show()
            } else if(mUser.isEmpty()){
                Toast.makeText(this, "Ingrese su nombre de usuario",
                    Toast.LENGTH_SHORT).show()
            } else {
                db.collection("users").document(mEmail).set(
                    hashMapOf("usuario" to mUser,"fecha" to mFecha,"contraseña" to mPassword)
                )
                createAccount(mEmail, mPassword)
                Toast.makeText(this, "Cuenta registrada con exito",Toast.LENGTH_SHORT).show()
            }
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
    private fun createAccount(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    val intent = Intent(this, Verificacion::class.java)
                    this.startActivity(intent)
                }else{
                    Log.w("TAG", "createUserWithEmail:failure",task.exception)
                    Toast.makeText(baseContext, "Autentificasion fallida",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun reaload() {
        val intent = Intent(this, Inicio::class.java)
        this.startActivity(intent)
    }
}