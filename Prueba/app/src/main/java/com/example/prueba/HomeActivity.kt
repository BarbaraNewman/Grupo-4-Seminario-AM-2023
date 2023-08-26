package com.example.prueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.rvHome)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Personaje>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..3) {
            data.add(Personaje("Personaje " + i, "https://static.wikia.nocookie.net/avatar/images/f/fa/Aang_en_el_Drag%C3%B3n_del_Jazm%C3%ADn.png/revision/latest?cb=20150414231706&path-prefix=es"))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = PersonajeHolder(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}