package com.example.prueba

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.prueba.dtos.Bio
import com.example.prueba.dtos.PhysicalDescription

@Entity(tableName = "personajes_table")
data class Personaje(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "physicalDescription") var physicalDescription: PhysicalDescription,

    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
