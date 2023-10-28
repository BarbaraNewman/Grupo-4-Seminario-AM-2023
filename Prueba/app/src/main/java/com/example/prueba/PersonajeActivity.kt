package com.example.prueba

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonajeActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personaje)


        val nombre = intent.getStringExtra("nombre")
        val imagenUrl = intent.getStringExtra("imagen")
        val genero = intent.getStringExtra("genero")
        val colorOjos = intent.getStringExtra("colorOjos")
        val colorPelo = intent.getStringExtra("colorPelo")



        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val imageAang = findViewById<ImageView>(R.id.imageAang)
        val txGenero = findViewById<TextView>(R.id.txtGenero)
        val txColorOjos = findViewById<TextView>(R.id.txtEyeColor)
        val txColorPelo = findViewById<TextView>(R.id.txtHairColor)


        txtNombre.text = nombre
        txGenero.text = genero
        txColorOjos.text = colorOjos
        txColorPelo.text = colorPelo

        // Carga la imagen usando Glide o la biblioteca de tu elección
        Glide.with(this)
            .load(imagenUrl)
            .into(imageAang)

        val btAtras = findViewById<Button>(R.id.btAtras)
        btAtras.setOnClickListener {
            //onBackPressed()
        // Volver a la actividad anterior
            val intentAtras = Intent(this, HomeActivity::class.java)
            startActivity(intentAtras)
        }
    }
}

