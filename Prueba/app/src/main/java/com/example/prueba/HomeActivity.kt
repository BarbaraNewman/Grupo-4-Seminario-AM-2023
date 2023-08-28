package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerview = findViewById<RecyclerView>(R.id.rvHome)

        val btnBack: Button = findViewById(R.id.backBtn)
        btnBack.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
            finish()
        }


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