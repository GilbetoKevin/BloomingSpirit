package com.`is`.bloomingspirit

import android.app.*

import android.content.Intent
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*


class Meditacion : AppCompatActivity() {
    private var milliseconds: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion)

        var butRegresar=findViewById<Button>(R.id.button9)
        var butMeditacion=findViewById<Button>(R.id.button6)
        var butTemporizador=findViewById<Button>(R.id.button7)
        val textView = findViewById<TextView>(R.id.textView35)
        var butNotificacion=findViewById<Button>(R.id.but_noti)

        //createChannel()

        butTemporizador.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val hourOfDay = currentTime.get(Calendar.HOUR_OF_DAY)
            val minute = currentTime.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val timeInMillis = (hour  * 60 * 1000) + (minute  * 1000)
                this.milliseconds = timeInMillis.toLong()
                startTimer()
            }, hourOfDay, minute, true)
            timePicker.show()
        }
        butRegresar.setOnClickListener{
            onBackPressed()
        }

        butMeditacion.setOnClickListener{
            val playlistLink = "https://open.spotify.com/episode/0T4twGUozUiRCccU1NM0VR?si=V7RVOF1oQtSiMAVqnVBPfA" // Reemplaza <ID de la playlist> con el ID de tu playlist de Spotify.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playlistLink))
            intent.setPackage("com.spotify.music")
            startActivity(intent)
        }

        butNotificacion.setOnClickListener {
            //scheduleNotification()
            val intent = Intent(this,Notificacion::class.java)
            startActivity(intent)
        }

    }
    private fun startTimer() {
        object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val timeRemaining = String.format("%02d:%02d", minutes, seconds)
                val timerTextView = findViewById<TextView>(R.id.textView35)
                timerTextView.text = timeRemaining
            }

            override fun onFinish() {
                val timerTextView = findViewById<TextView>(R.id.textView35)
                timerTextView.text = "00:00"
                val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    // deprecated in API 26
                    vibrator.vibrate(1000)
                }
            }
        }.start()
    }
}
