package com.`is`.bloomingspirit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class NochesRelajantes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noches_relajantes)


        var butHome=findViewById<Button>(R.id.but_home)
        var butRegresar=findViewById<Button>(R.id.but_Regresar)
        var butMusicaSuave = findViewById<Button>(R.id.but_MusicaSuave)
        var butMusicaNat = findViewById<Button>(R.id.but_Naturaleza)
        var butMusicaRB = findViewById<Button>(R.id.but_RuidoBlanco)

        butMusicaSuave.setOnClickListener{
            val playlistLink = "https://open.spotify.com/episode/34nJeqm8HTkpLPH8y2RpPd?si=0wwW-2v0Ql2b1H7OjHx_5A" // Reemplaza <ID de la playlist> con el ID de tu playlist de Spotify.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playlistLink))
            intent.setPackage("com.spotify.music")
            startActivity(intent)
        }
        butMusicaNat.setOnClickListener{
            val playlistLink = "https://open.spotify.com/playlist/1Wc3UAS3twr8sXpA4KlTHu?si=Xh8g6j5WTkKcZiaYXrI8cQ" // Reemplaza <ID de la playlist> con el ID de tu playlist de Spotify.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playlistLink))
            intent.setPackage("com.spotify.music")
            startActivity(intent)
        }
        butMusicaRB.setOnClickListener{
            val playlistLink = "https://open.spotify.com/playlist/37i9dQZF1DWUZ5bk6qqDSy?si=hC7GvZ97SnC4MZzVrkArfA" // Reemplaza <ID de la playlist> con el ID de tu playlist de Spotify.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(playlistLink))
            intent.setPackage("com.spotify.music")
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
}