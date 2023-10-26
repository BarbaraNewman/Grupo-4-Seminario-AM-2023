package com.example.prueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.prueba.configurations.RetrofitClient
import com.example.prueba.dtos.Character
import com.example.prueba.endpoints.MyApi
import retrofit2.Call
import android.util.Log
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var tvServicioRest: TextView
    lateinit var rvPersonajes: RecyclerView
    lateinit var personajesAdapter: PersonajeHolder
    lateinit var data: ArrayList<Personaje>
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvPersonajes = findViewById(R.id.rvHome)
        personajesAdapter = PersonajeHolder(getPersonajes(), this)
        rvPersonajes.adapter = personajesAdapter

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        //supportActionBar!!.title = resources.getString(R.string.titulo)
    }

    fun getPersonajes(): MutableList<Personaje> {
        //var personajes: MutableList<Personaje> = ArrayList()
        //var bdd = DatabaseApp.getDatabase(this)
        //personajes.addAll(bdd.personajeDao().getAll())

        val data = ArrayList<Personaje>()
        val adapter = PersonajeHolder(ArrayList(), this)
        //recyclerview.adapter = adapter

        val api = RetrofitClient.retrofit.create(MyApi::class.java)
        val call = api.getPersonajeAvatar()

        call.enqueue(object : retrofit2.Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
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
                // Handle the failure or error here
                Log.e("ERROR", t.message ?: "")
            }
        }
        )

        return data
    }

}