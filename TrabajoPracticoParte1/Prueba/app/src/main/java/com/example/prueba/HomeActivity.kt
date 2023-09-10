package com.example.prueba

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Personajes"
            setDisplayHomeAsUpEnabled(true)
        }

        val recyclerview = findViewById<RecyclerView>(R.id.rvHome)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Personaje>()

        for (i in 1..3) {
            data.add(
                Personaje(
                    "Personaje " + i,
                    "https://static.wikia.nocookie.net/avatar/images/f/fa/Aang_en_el_Drag%C3%B3n_del_Jazm%C3%ADn.png/revision/latest?cb=20150414231706&path-prefix=es"
                )
            )
        }

        val adapter = PersonajeHolder(data)

        recyclerview.adapter = adapter

    }
}