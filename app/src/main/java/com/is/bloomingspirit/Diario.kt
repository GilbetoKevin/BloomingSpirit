package com.`is`.bloomingspirit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class Diario : AppCompatActivity() {
    private  var db= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diario)
        var butHome=findViewById<Button>(R.id.but_home)
        val diarioo=findViewById<EditText>(R.id.diario)
        val guardar=findViewById<Button>(R.id.nueva_entrada)
        val viewFecha =findViewById<TextView>(R.id.textFecha)

        var textoDiario:String=""
        var nombre:String=""
        var fecha:String=""
        var contraseña:String=""

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }


        val fechaView = intent.getStringExtra("fecha").toString()
        viewFecha.setText(fechaView).toString()

        guardar.setOnClickListener {
            FirebaseAuth.getInstance().currentUser?.let { user ->
                val email = user.email
                val actualizacionCampo = HashMap<String, Any>()
                actualizacionCampo[fechaView] = diarioo.text.toString()
                db.collection("users").document(email.toString())
                    .set(actualizacionCampo, SetOptions.merge())
                    .addOnSuccessListener {
                    // El campo se actualizó correctamente
                    }
                        .addOnFailureListener { e ->
                        // Ocurrió un error al actualizar el campo
                }
            }
            Toast.makeText(this, "Se creo una nueva entrada",
                Toast.LENGTH_SHORT).show()

        }
        FirebaseAuth.getInstance().currentUser?.let { user ->
            val email = user.email

            db.collection("users").document(email.toString()).get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        textoDiario = document.data?.get(fechaView)?.toString().toString()

                        if (textoDiario== "null") {
                            diarioo.setText("")
                        } else {
                            diarioo.setText(textoDiario)
                        }
                    }
                }
        } ?: run {

            }

        diarioo.requestFocus()
    }
}
