package com.`is`.bloomingspirit

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.`is`.bloomingspirit.databinding.ActivityPerfilBinding
import java.util.*
import java.util.regex.Pattern


class Perfil : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    private lateinit var auth: FirebaseAuth
    private  var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        var nombre:String=""
        var fecha:String=""
        var contraseña:String=""
        var textNombre=findViewById<TextView>(R.id.textNombre)
        var textFecha=findViewById<TextView>(R.id.textFecha)
        val botExt = findViewById<Button>(R.id.bot_cerrarSesion)
        val botInicio = findViewById<Button>(R.id.but_inicio)
        val botNombre = findViewById<Button>(R.id.but_usuario)
        val botFecha = findViewById<Button>(R.id.but_fecha)
        val botSabeNombre = findViewById<Button>(R.id.but_sabe_nombre)
        val botSabeFecha = findViewById<Button>(R.id.but_sabe_fecha)
        var editNombre=findViewById<EditText>(R.id.editNombre)
        var editFecha=findViewById<EditText>(R.id.editFecha)
        var formatoFecha=findViewById<TextView>(R.id.textFormatoFecha)

        botNombre.setOnClickListener{
            textNombre.visibility= View.GONE
            editNombre.visibility=View.VISIBLE
            botNombre.visibility=View.GONE
            botSabeNombre.visibility=View.VISIBLE

        }
        editFecha.setOnClickListener{
            val calendario = Calendar.getInstance()
            val anio = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            val selectorFecha = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, anioSeleccionado, mesSeleccionado, diaSeleccionado ->
                editFecha.setText("$diaSeleccionado/${mesSeleccionado+1}/$anioSeleccionado")
            }, anio, mes, dia)
            selectorFecha.show()
        }

        botSabeNombre.setOnClickListener {

            textNombre.visibility= View.VISIBLE
            editNombre.visibility=View.GONE
            botNombre.visibility=View.VISIBLE
            botSabeNombre.visibility=View.GONE
            if(!editNombre.text.toString().isEmpty()) {
                val mUsuario = editNombre.text.toString()
                FirebaseAuth.getInstance().currentUser?.let { user ->
                    val email = user.email
                    db.collection("users").document(email.toString()).get()
                        .addOnSuccessListener { document ->
                            if (document.exists()) {
                                nombre = document.data?.get("usuario").toString()
                                fecha = document.data?.get("fecha").toString()
                                contraseña = document.data?.get("contraseña").toString()
                            }
                        }
                    db.collection("users").document(email.toString()).set(
                        hashMapOf(
                            "usuario" to mUsuario,
                            "fecha" to fecha,
                            "contraseña" to contraseña
                        )
                    )
                    db.collection("users").document(email.toString()).get()
                        .addOnSuccessListener { document ->
                            if (document.exists()) {
                                nombre = document.data?.get("usuario").toString()
                                textNombre.setText(nombre)
                            }
                        } ?: run {

                    }
                }
            }else{
                Toast.makeText(baseContext, "El campo de nombre esta vacío",
                    Toast.LENGTH_SHORT).show()
            }
        }
        botFecha.setOnClickListener{
            textFecha.visibility= View.GONE
            editFecha.visibility=View.VISIBLE
            botFecha.visibility=View.GONE
            botSabeFecha.visibility=View.VISIBLE
            formatoFecha.visibility=View.VISIBLE
        }
        botSabeFecha.setOnClickListener {
            textFecha.visibility= View.VISIBLE
            editFecha.visibility=View.GONE
            botFecha.visibility=View.VISIBLE
            botSabeFecha.visibility=View.GONE
            formatoFecha.visibility=View.GONE


            val mFecha=editFecha.text.toString()
            FirebaseAuth.getInstance().currentUser?.let { user ->
                val email = user.email
                db.collection("users").document(email.toString()).get()
                    .addOnSuccessListener { document ->
                        if (document.exists()) {
                            nombre = document.data?.get("usuario").toString()
                            fecha = document.data?.get("fecha").toString()
                            contraseña = document.data?.get("contraseña").toString()
                        }
                    }
                db.collection("users").document(email.toString()).set(
                    hashMapOf("usuario" to nombre, "fecha" to mFecha, "contraseña" to contraseña)
                )
                db.collection("users").document(email.toString()).get()
                    .addOnSuccessListener { document ->
                        if (document.exists()) {
                            fecha = document.data?.get("fecha").toString()
                            textFecha.setText(fecha)
                            editFecha.setText(fecha)
                        }
                    }
            }

        }

        botInicio.setOnClickListener{
            onBackPressed()
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
                    textNombre.setText(nombre)
                    textFecha.setText(fecha)
                    editNombre.setText(nombre)
                    editFecha.setText(fecha)
                }else{
                    textNombre.setText("no se encotro")
                }

            }
        } ?: run {

        }

    }
    private fun singOut(){
        Firebase.auth.signOut()
        val intent= Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}