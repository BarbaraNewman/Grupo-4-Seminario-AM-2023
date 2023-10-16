package com.example.prueba

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.prueba.R
import com.example.prueba.configurations.RetrofitClient
import com.example.prueba.dtos.Character
import com.example.prueba.endpoints.MyApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var tvServicioRest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerview = findViewById<RecyclerView>(R.id.rvHome)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Personaje>()
        val adapter = PersonajeHolder(data)
        recyclerview.adapter = adapter

        val api = RetrofitClient.retrofit.create(MyApi::class.java)
        val call = api.getPersonajeAvatar()

        call.enqueue(object : retrofit2.Callback<List<Character>> {
            override fun onResponse(call: Call<List<Character>>, response: retrofit2.Response<List<Character>>) {
                if (response.isSuccessful) {
                    val characters = response.body()
                    if (characters != null) {
                        val personajes = characters.map { character ->
                            Personaje(character.name ?: "", character.image ?: "")
                        }
                        data.addAll(personajes)
                        adapter.notifyDataSetChanged()
                    }
                }
            }



            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                // Handle network errors
                Log.e("ERROR", t.message ?: "")
            }
        })
    }

}