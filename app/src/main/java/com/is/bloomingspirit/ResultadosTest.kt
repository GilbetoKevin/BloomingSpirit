package com.`is`.bloomingspirit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadosTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados_test)

        val mensaje = intent.getStringExtra("mensaje")
        findViewById<TextView>(R.id.textoMensaje).text = mensaje

    }
}