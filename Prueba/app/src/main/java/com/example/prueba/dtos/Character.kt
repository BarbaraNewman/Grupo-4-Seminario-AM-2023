package com.example.prueba.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    //var photoUrl:String,
    //var allies:String
    val id: Int?,
    val name: String?,
    val image: String?
)
