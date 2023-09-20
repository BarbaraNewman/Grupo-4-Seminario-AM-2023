package com.example.prueba

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personajes_table")
data class Personaje (
    @ColumnInfo(name = "personaje") var personaje:String,
    @ColumnInfo(name = "imagen") var imagen:String
    ){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
