package com.`is`.bloomingspirit

import android.app.TimePickerDialog
import android.widget.TimePicker
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import java.util.*

class Corredor : AppCompatActivity() {

    private var milliseconds: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corredor)

        var butHome=findViewById<Button>(R.id.but_home)
        var butNoti=findViewById<Button>(R.id.but_Noti)
        var butRegresar=findViewById<Button>(R.id.but_Regresar)
        val selectTimeButton = findViewById<Button>(R.id.but_Temp)
        val butMusicaCorredor = findViewById<Button>(R.id.but_MusicaCorredor)

        butMusicaCorredor.setOnClickListener {
            val playlistLink = "https://open.spotify.com/track/2aQpISWUBToaF84DDiTeRV?si=opRZMXucRlKmrsat7RD62Q" // Reemplaza <ID de la playlist> con el ID de tu playlist de Spotify.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playlistLink))
            intent.setPackage("com.spotify.music")
            startActivity(intent)
        }


        selectTimeButton.setOnClickListener {
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

        butNoti.setOnClickListener{
            val intent = Intent(this,Notificacion::class.java)
            intent.putExtra("titulo", "Es hora de Correr")
            intent.putExtra("context", "Programaste Correr a esta hora")
            intent.putExtra("bigText", "Correr es beneficioso para mejorar la condición cardiovascular, fortalecer los músculos, quemar calorías, reducir el estrés, aumentar la resistencia, promover la salud mental y mejorar la salud en general..")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        butHome.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        butRegresar.setOnClickListener{
            onBackPressed()
        }
    }
   private fun startTimer() {
        object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val timeRemaining = String.format("%02d:%02d", minutes, seconds)
                val timerTextView = findViewById<TextView>(R.id.textTiempo)
                timerTextView.text = timeRemaining
            }

            override fun onFinish() {
                val timerTextView = findViewById<TextView>(R.id.textTiempo)
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