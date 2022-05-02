package com.example.visitorscounter.model

import com.example.visitorscounter.model.dto.Entity
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface IResponseData {
     fun getHost(onResult:(result: Entity) -> Unit)
}