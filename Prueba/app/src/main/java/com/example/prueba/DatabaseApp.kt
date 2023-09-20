package com.example.prueba

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Personaje::class], version = 1)
abstract class DatabaseApp: RoomDatabase() {

    abstract fun personajeDao(): PersonajeDao

    companion object{

        private var INSTANCIA: DatabaseApp?= null

        fun getDatabase(contexto: Context) : DatabaseApp{
            if(INSTANCIA == null){
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(
                        contexto, DatabaseApp::class.java, "base_app_personajes")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }



    }

}