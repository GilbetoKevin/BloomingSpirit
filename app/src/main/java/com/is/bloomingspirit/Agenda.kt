package com.`is`.bloomingspirit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Agenda : AppCompatActivity() {
    private  var db= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)
        val calendario = findViewById<CalendarView>(R.id.calendario)
        val butHome=findViewById<Button>(R.id.but_home)
        val butNueva=findViewById<Button>(R.id.nueva_entrada)


        var textoDiario:String=""
        var nombre:String=""
        var fecha:String=""
        var contraseña:String=""

        butNueva.setOnClickListener{

            val calendar: Calendar = Calendar.getInstance()
            val currentTimeInMillis: Long = calendar.getTimeInMillis()

            calendar.setTimeInMillis(currentTimeInMillis);
            val formatoFecha = SimpleDateFormat("dd/MM/yyyy")
            val fechaFormateada = formatoFecha.format(calendar.getTime())
            println("fecha con formato "+fechaFormateada)

            FirebaseAuth.getInstance().currentUser?.let { user ->
                val email = user.email
                val documentoId = email.toString()
                val campoNuevo = fechaFormateada
                val valorCampoNuevo = ""

                // Verificar si el documento existe antes de agregar un nuevo campo
                db.collection("users").document(documentoId).get()
                    .addOnSuccessListener { documentSnapshot ->
                        if (!documentSnapshot.exists()) {
                            // El documento no existe, agregar el nuevo campo
                            val nuevoCampo = HashMap<String, Any>()
                            nuevoCampo[campoNuevo] = valorCampoNuevo

                            db.collection("users").document(documentoId)
                                .set(nuevoCampo, SetOptions.merge())
                                .addOnSuccessListener {
                                    // El campo se agregó correctamente o se fusionó con los datos existentes
                                }
                                .addOnFailureListener { e ->
                                    // Ocurrió un error al agregar el campo
                                }
                        }
                    }
            }

            val intent = Intent(this,Diario::class.java)
            intent.putExtra("fecha", fechaFormateada)
            startActivity(intent)

        }

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        // Obtener la fecha actual
        val calendar: Calendar = Calendar.getInstance()
        val currentTimeInMillis: Long = calendar.getTimeInMillis()
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy")
        val fechaFormateada = formatoFecha.format(calendar.getTime())
        val fecha1: Date

        try {
            fecha1 = formatoFecha.parse(fechaFormateada)
            val milisegundos = fecha1.time
            println("Fecha en milisegundos: $milisegundos")
            calendario.setDate(milisegundos)

        } catch (e: ParseException) {
            e.printStackTrace()
        }

        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar: Calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            val fechaSeleccionada: Date = calendar.time
            val formatoFecha = SimpleDateFormat("dd/MM/yyyy")
            val fechaString = formatoFecha.format(fechaSeleccionada)

            //
            FirebaseAuth.getInstance().currentUser?.let { user ->
                val email = user.email
                val documentoId = email.toString()
                val campoNuevo = fechaString
                val valorCampoNuevo = ""

                // Verificar si el documento existe antes de agregar un nuevo campo
                db.collection("users").document(documentoId).get()
                    .addOnSuccessListener { documentSnapshot ->
                        if (!documentSnapshot.exists()) {
                            // El documento no existe, agregar el nuevo campo
                            val nuevoCampo = HashMap<String, Any>()
                            nuevoCampo[campoNuevo] = valorCampoNuevo

                            db.collection("users").document(documentoId)
                                .set(nuevoCampo, SetOptions.merge())
                                .addOnSuccessListener {
                                    // El campo se agregó correctamente o se fusionó con los datos existentes
                                }
                                .addOnFailureListener { e ->
                                    // Ocurrió un error al agregar el campo
                                }
                        }
                    }
            }


            //

                // Imprimir la fecha seleccionada
                println("Fecha seleccionada: $fechaString")
                val intent = Intent(this, Diario::class.java)
                intent.putExtra("fecha", fechaString)
                startActivity(intent)
            }
        }

        // Establecer la fecha actual como la fecha seleccionada del calendario



}