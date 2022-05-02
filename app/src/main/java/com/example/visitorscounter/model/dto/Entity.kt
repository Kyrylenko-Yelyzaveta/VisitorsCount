package com.example.visitorscounter.model.dto

import com.google.firebase.database.PropertyName

data class Entity(
    @PropertyName("home")
    val home: String = "",
    @PropertyName("link")
    val link: String = ""
)