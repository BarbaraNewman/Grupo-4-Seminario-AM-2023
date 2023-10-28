package com.example.prueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.prueba.configurations.RetrofitClient
import com.example.prueba.dtos.Bio
import com.example.prueba.dtos.PhysicalDescription
import com.example.prueba.endpoints.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var tvServicioRest : TextView
    private lateinit var adapter : PersonajeHolder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lateinit var toolbar: Toolbar

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Personajes"


        val recyclerview = findViewById<RecyclerView>(R.id.rvHome)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Personaje>()

        val api = RetrofitClient.retrofit.create(MyApi::class.java)
        val call = api.getPersonajeAvatar()
        val adapter = PersonajeHolder(data, this)
        recyclerview.adapter = adapter

        // Corrutina para la llamada de la API
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = api.getPersonajeAvatar().execute()
                if (response.isSuccessful) {
                    val characters = response.body()
                    if (characters != null) {
                        val personajes = characters.map { character ->
                            val physicalDescription = character.physicalDescription ?: PhysicalDescription("", "", "", "")

                            Personaje(
                                character.name ?: "",
                                character.image ?: "",
                                physicalDescription
                            )
                        }

                        // Actualiza la vista
                        launch(Dispatchers.Main) {
                            data.addAll(personajes)
                            adapter.notifyDataSetChanged()
                        }
                    }
                } else {
                    Log.e("ERROR", "ERROR RESPUESTA API")
                }
            } catch (e: Exception) {
                // Otro errror
                Log.e("ERROR", e.message ?: "")
            }
        }
    }

}