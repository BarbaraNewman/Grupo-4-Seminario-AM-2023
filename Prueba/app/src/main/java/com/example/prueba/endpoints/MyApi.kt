package com.example.prueba.endpoints

import com.example.prueba.dtos.Character
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {

    //@GET("/api/v1/characters")
    @GET("/avatar/characters")
    // fun getPersonajeAvatar() : List<Character>
    fun getPersonajeAvatar() : Call<List<Character>>
}