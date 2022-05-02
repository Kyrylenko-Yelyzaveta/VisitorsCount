package com.example.visitorscounter.model

import android.util.Log
import com.example.visitorscounter.model.dto.Entity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResponseData : IResponseData {
    companion object {
        private var database: DatabaseReference = Firebase.database.reference
    }

    override fun getHost(onResult: (result: Entity) -> Unit) {
        database.get().addOnSuccessListener {


            onResult(it.getValue(Entity::class.java)!!)
        }.addOnFailureListener {


        }.addOnCanceledListener {

        }.addOnCompleteListener {

        }
    }

}