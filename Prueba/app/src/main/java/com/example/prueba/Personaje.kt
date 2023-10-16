package com.example.prueba

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personajes_table")
data class Personaje (
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "image") var image:String,

    @PrimaryKey(autoGenerate = true) var id:Int = 0
)
