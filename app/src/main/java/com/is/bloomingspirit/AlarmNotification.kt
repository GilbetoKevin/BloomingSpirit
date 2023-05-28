package com.`is`.bloomingspirit

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmNotification : BroadcastReceiver() {

    var titulo: String = ""
    var contexto: String = ""
    var bigText: String = ""

    companion object {
        const val NOTIFICATION_ID = 1
    }

    override fun onReceive(context: Context, intent: Intent?) {
        obtenerTitulo(intent)
        obtenerContext(intent)
        obtenerbigText(intent)
        createSimpleNotification(context)
    }

    private fun obtenerTitulo(intent: Intent?) {
        titulo = intent?.getStringExtra("titulo") ?: ""
    }

    private fun obtenerContext(intent: Intent?) {
        contexto = intent?.getStringExtra("context") ?: ""
    }

    private fun obtenerbigText(intent: Intent?) {
        bigText = intent?.getStringExtra("bigText") ?: ""
    }

    private fun createSimpleNotification(context: Context) {
        val intent = Intent(context, Meditacion::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, flag)

        val notification = NotificationCompat.Builder(context, Notificacion.MY_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_home_24)
            .setContentTitle(titulo)
            .setContentText(contexto)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(bigText)
            )
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }
}
