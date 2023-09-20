package com.example.prueba

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonajeDao {
    @Query("SELECT * FROM personajes_table")
    fun getAll(): List<Personaje>
    @Insert
    fun insert(personajes: Personaje)
}