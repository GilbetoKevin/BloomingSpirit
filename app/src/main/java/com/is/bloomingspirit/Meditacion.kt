package com.`is`.bloomingspirit

import android.app.*
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.`is`.bloomingspirit.AlarmNotification.Companion.NOTIFICATION_ID
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

class Meditacion : AppCompatActivity() {
    companion object {
        const val MY_CHANNEL_ID = "myChannel"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion)

        var butRegresar=findViewById<Button>(R.id.button9)
        var butMeditacion=findViewById<Button>(R.id.button6)
        var butTemporizador=findViewById<Button>(R.id.button7)
        val textView = findViewById<TextView>(R.id.textView35)
        var butNotificacion=findViewById<Button>(R.id.but_noti)
        createChannel()

        butRegresar.setOnClickListener{
            val intent = Intent(this,HabitosRutinas::class.java)
            startActivity(intent)
        }

        butMeditacion.setOnClickListener{
            val playlistLink = "https://open.spotify.com/episode/0T4twGUozUiRCccU1NM0VR?si=V7RVOF1oQtSiMAVqnVBPfA" // Reemplaza <ID de la playlist> con el ID de tu playlist de Spotify.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playlistLink))
            intent.setPackage("com.spotify.music")
            startActivity(intent)
        }
        butTemporizador.setOnClickListener{
            val timePicker = TimePickerDialog(this, { _, hourOfDay, minute ->
                val totalSeconds = hourOfDay * 3600 + minute * 60
                object : CountDownTimer((totalSeconds * 1000).toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        // Actualiza el texto del botón con el tiempo restante
                        textView.visibility = View.GONE
                        butTemporizador.text = "                   " + (millisUntilFinished/1000).toString() + "s"
                    }

                    override fun onFinish() {
                        // Acciones a realizar cuando el temporizador finaliza
                        butTemporizador.text = " "
                        textView.visibility = View.VISIBLE
                        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            vibrator.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE))
                        } else {
                            // deprecated in API 26
                            vibrator.vibrate(1000)
                        }

                    }
                }.start()
            }, 0, 0, true)
            timePicker.show()
        }
        butNotificacion.setOnClickListener {
            scheduleNotification()
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun scheduleNotification() {
        val intent = Intent(applicationContext, AlarmNotification::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            NOTIFICATION_ID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + 15000, pendingIntent)
        val fecha2 = LocalDateTime.of(2023, 3, 22, 23, 6)
        val duracion = Duration.between(LocalDateTime.now(), fecha2)
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + duracion.toMillis() , pendingIntent)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().timeInMillis + 15000 , pendingIntent)
        println(Calendar.getInstance().timeInMillis)
        println(duracion.toMillis() )
        Toast.makeText(this, "15 segundos para la notificacion",
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