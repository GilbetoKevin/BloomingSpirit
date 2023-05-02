package com.`is`.bloomingspirit

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

class Notificacion : AppCompatActivity() {
    companion object {
        const val MY_CHANNEL_ID = "myChannel"
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacion)

        var butGuardar=findViewById<Button>(R.id.but_guardar)
        var butFecha=findViewById<Button>(R.id.but_fecha_noty)
        var butHora=findViewById<Button>(R.id.but_hora_noty)
        var añoSelec : Int=0
        var mesSelec : Int=0
        var diaSelec : Int=0
        var horaSelec : Int=0
        var minutoSelec : Int=0
        var textFecha=findViewById<TextView>(R.id.textViewFecha)
        var textHora=findViewById<TextView>(R.id.textViewHora)

        createChannel()
        butFecha.setOnClickListener{
            val calendario = Calendar.getInstance()
            val anio = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            val selectorFecha = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, anioSeleccionado, mesSeleccionado, diaSeleccionado ->
                añoSelec=anioSeleccionado
                mesSelec=mesSeleccionado+1
                diaSelec=diaSeleccionado
                textFecha.setText(""+añoSelec+"/"+mesSelec+"/"+diaSelec)
            }, anio, mes, dia)
            selectorFecha.show()

            butHora.setOnClickListener{
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val minute = calendar.get(Calendar.MINUTE)
                val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    horaSelec=hourOfDay
                    minutoSelec=minute
                    textHora.setText(""+horaSelec+":"+minutoSelec)
                }, hour, minute, false)

                println(añoSelec)
                println(mesSelec)
                println(diaSelec)
                println(horaSelec)
                println(minutoSelec)
                timePickerDialog.show()

                butGuardar.setOnClickListener {
                    scheduleNotification(añoSelec,mesSelec,diaSelec,horaSelec,minutoSelec)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun scheduleNotification(año:Int,mes:Int,dia:Int,hora:Int,minuto:Int) {
        val intent = Intent(applicationContext, AlarmNotification::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            AlarmNotification.NOTIFICATION_ID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + 15000, pendingIntent)
        val fecha2 = LocalDateTime.of(año, mes, dia, hora, minuto)
        val duracion = Duration.between(LocalDateTime.now(), fecha2)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + duracion.toMillis() , pendingIntent)
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + 15000 , pendingIntent)
        println(Calendar.getInstance().timeInMillis)
        println(duracion.toMillis())
        Toast.makeText(this, "Notificación progamada el "+año+"/"+mes+"/"+dia+"  "+hora+":"+minuto,
            Toast.LENGTH_SHORT).show()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                MY_CHANNEL_ID,
                "MySuperChannel",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "SUSCRIBETE"
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}